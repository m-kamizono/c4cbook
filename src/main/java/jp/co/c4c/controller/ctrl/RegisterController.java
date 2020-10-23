package jp.co.c4c.controller.ctrl;

import jp.co.c4c.controller.form.RegisterBookForm;
import jp.co.c4c.db.dto.BK_M_BookDto;
import jp.co.c4c.db.dto.WebSessionDto;
import jp.co.c4c.service.CommonService;
import jp.co.c4c.service.RegisterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/register")
@SessionAttributes("webSessionDto")
public class RegisterController {

    @Autowired
    RegisterService registerService;
    @Autowired
    CommonService commonService;


    //セッションのオブジェクト代入格納メソッド
    @ModelAttribute("webSessionDto")
    public WebSessionDto setWebSessionDto(WebSessionDto webSessionDto) {
        return webSessionDto;
    }
    
    @RequestMapping
    public String init(@ModelAttribute("webSessionDto") WebSessionDto webSessionDto,
                       Model model, RegisterBookForm registerBookForm) {
//        // ログインチェック
//        boolean isLogined = commonService.isLogined(webSessionDto);
//        if (!isLogined)
//            return "redirect:login";
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String register(@ModelAttribute("registerBookForm") RegisterBookForm registerBookForm, RedirectAttributes redirectAttributes) {

        BK_M_BookDto bk_m_bookDto = new BK_M_BookDto();
        BeanUtils.copyProperties(registerBookForm, bk_m_bookDto);

        MultipartFile multipartFile = registerBookForm.getBookImg();
        byte[] binaryData = new byte[0];
        try {
            binaryData = multipartFile.getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }

        bk_m_bookDto.setBookImg(binaryData);

        registerService.regBook(bk_m_bookDto);
        redirectAttributes.addFlashAttribute("message", "登録が完了しました");
        return "redirect:register";
    }
}
