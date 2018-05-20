package com.zxh.pettrade.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zxh.pettrade.entity.CategorySecond;
import com.zxh.pettrade.entity.Pet;
import com.zxh.pettrade.service.CategorySecondService;
import com.zxh.pettrade.service.PetService;
import com.zxh.pettrade.util.StringTools;

/**
 * 宠物管理控制层
 * 
 * @author zhaoxianhai
 *
 */
@Controller
public class PetController {
	@Autowired
	private PetService petService;

	@Autowired
	private CategorySecondService categorySecondService;

	/**
	 * 分页显示宠物
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listpet/{currpage}")
	public String listPet(@PathVariable("currpage") Integer currpage, Map<String, Object> map) {
		// 宠物的页数
		Integer totalPetPage = petService.countPetPage();
		// 分页查询宠物
		List<Pet> listPet = petService.listPet(currpage);
		map.put("listPet", listPet);
		map.put("currPage", currpage);
		map.put("totalPetPage", totalPetPage);
		return "admin/pet/listpet";
	}

	/**
	 * 跳至添加宠物页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "toaddpet")
	public ModelAndView toAddPet() {
		ModelAndView mv = new ModelAndView("admin/pet/addpet");
		// 查询所有二级分类
		List<CategorySecond> categorySecond = categorySecondService.listCategorySecond();
		mv.addObject("categotySeconds", categorySecond);
		return mv;

	}

	/**
	 * 添加宠物
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addpet", method = RequestMethod.POST)
	public ModelAndView addPet(Pet pet, @RequestParam("upload") MultipartFile upload, Integer csid,
			HttpServletRequest request) {
		// 获取文件保存的路径
		ServletContext servletRequest = request.getSession().getServletContext();
		String path = servletRequest.getRealPath("/pets/1");
		// 获取文件名称
		String fileName = upload.getOriginalFilename();
		System.out.println("====" + fileName);
		// 获取上传文件的扩展名
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		// 为了防止上传同名文件，需要给上传文件重新命名
		String tempFileName = StringTools.getUUID().toString() + suffix;
		try {
			FileUtils.writeByteArrayToFile(new File(path, tempFileName), upload.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 设置文件的路径
		pet.setImage("pets/1/" + tempFileName);

		// 设置日期
		pet.setPdate(new Date());

		// 二级类目
		CategorySecond categorySecond = categorySecondService.findCategorySecond(csid);
		pet.setCategorySecond(categorySecond);
		// 保存宠物
		petService.savePet(pet);
		ModelAndView mv = new ModelAndView("redirect:/listpet/1");
		return mv;

	}
	
	/**
	 * 跳至宠物修改页
	 * @param pid
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/toEditPet/{pid}")
	public String editProduct(@PathVariable("pid") Integer pid, Map<String, Object> map){
		Pet pet = petService.getPet(pid);
		List<CategorySecond> categotySeconds = categorySecondService.listCategorySecond();
		map.put("categorySeconds", categotySeconds);
		map.put("pet", pet);
		return "admin/pet/edit";
	}
	/**
	 * 修改宠物
	 */
	@RequestMapping(value="/updatePet", method=RequestMethod.POST)
	public ModelAndView updateProduct(Pet pet, 
			@RequestParam("upload") MultipartFile upload, Integer csid, HttpServletRequest request){
		//获取文件的保存路径
		ServletContext servletContext = request.getSession().getServletContext();
		
		//获取上传文件的名称
		String fileName = upload.getOriginalFilename();
		System.out.println("====" + fileName);

		//查询旧的宠物
		Pet op = petService.getPet(pet.getPid());
		
		//获取本来的文件的名称  pets/1/e3570d00574747eeb09465c125727fa4.jpg
		String oldFileName = "";
		if("".equals(op.getImage())){
			int begin = op.getImage().lastIndexOf("/");
			oldFileName = op.getImage().substring(begin+1, op.getImage().length());
		}
		
		if( !"".equals(fileName) && fileName != oldFileName){
			String path = servletContext.getRealPath("/pets/1");
			
			//得到上传文件的扩展名
			String suffix = fileName.substring(fileName.lastIndexOf("."));
			//为了防止上传同名文件，需要给上传文件重新命名
			String tempFileName = StringTools.getUUID().toString() + suffix;
			
			try {
				FileUtils.writeByteArrayToFile(new File(path, tempFileName), upload.getBytes() );
			} catch (IOException e) {
				e.printStackTrace();
			}
			//设置文件的路径
			pet.setImage("pets/1/" + tempFileName);
			
			pet.setPdate(new Date());
		}else{
			pet.setImage(op.getImage());
			pet.setPdate(new Date());
		}
		//二级类目
		CategorySecond categorySecond = categorySecondService.findCategorySecond(csid);
		pet.setCategorySecond(categorySecond);
		
		//保存宠物
		petService.updatePet(pet);
		
		ModelAndView mv = new ModelAndView("redirect:/listpet/1");
		return mv;
	}
	
	/**
	 * 删除宠物
	 */
	@RequestMapping(value="/deletePet/{pid}/{page}")
	public ModelAndView deletePet(@PathVariable("pid") Integer pid,
			@PathVariable("page") Integer page, HttpServletRequest request){
		// 获取商品对象
		Pet pet = petService.getPet(pid);
		
		//获取文件的目录
		String path = request.getSession().getServletContext().getRealPath("/" + pet.getImage());
		
		//获得文件对象
		File file = new File(path);
		//删除文件对象
		file.delete();
		
		//删除宠物
		petService.deletePet(pet);
		
		//删除哪一页即停留在哪一页
		ModelAndView mv = new ModelAndView("redirect:/listpet/" + page);
		return mv;
	}
	
}
