package jp.co.c4c.controller.ctrl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.co.c4c.controller.form.DetailForm;
import jp.co.c4c.db.dto.V_LendHistoryDto;
import jp.co.c4c.db.dto.WebSessionDto;
import jp.co.c4c.service.CommonService;
import jp.co.c4c.service.DetailService;

@Controller
@RequestMapping("/detail")
@SessionAttributes("webSessionDto")
public class DetailController {

    @Autowired
    DetailService detailService;
    @Autowired
    CommonService commonService;

    //セッションのオブジェクト代入格納メソッド
    @ModelAttribute("webSessionDto")
    public WebSessionDto setWebSessionDto(WebSessionDto webSessionDto) {
        return webSessionDto;
    }

    @RequestMapping
    public String init(@ModelAttribute("webSessionDto") WebSessionDto webSessionDto, @RequestParam("bookId") int bookId,
            Model model, DetailForm form) {
        // ログインチェック
        boolean isLogined = commonService.isLogined(webSessionDto);
        if (!isLogined) return "redirect:login";

        // 全メンバー
        form.setBk_M_MemBasicDtoList(detailService.getAllMembers());
        // 対象の本
        form.setV_TopAndDetailDto(detailService.getBookById(bookId));

        // 貸出履歴　返却ステータス以外を除外
        List<V_LendHistoryDto> lendHistoryDtoList = detailService.getLendHistorysByBookId(bookId);
        Iterator<V_LendHistoryDto> iterator = lendHistoryDtoList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getLendStatus() != 19) {
                iterator.remove();
            }
        }
        form.setV_LendHistoryDtoList(lendHistoryDtoList);

        // お気に入りしてる人
        form.setV_FavoriteMemberDtoList(detailService.getFavoriteMembersById(bookId));
        // おすすめしてる人
        form.setV_RecomMemDtoList(detailService.getRecomMembersById(bookId));
        return "detail";


    }

}
