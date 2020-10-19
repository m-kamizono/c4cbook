package jp.co.c4c.controller.ctrl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.co.c4c.constant.LendStatus;
import jp.co.c4c.controller.form.TopForm;
import jp.co.c4c.db.dto.BK_T_LendDto;
import jp.co.c4c.db.dto.BK_T_NewsReadDto;
import jp.co.c4c.db.dto.V_LendHistoryDto;
import jp.co.c4c.db.dto.V_MyFavoriteBookDto;
import jp.co.c4c.db.dto.V_MyLendHistoryDto;
import jp.co.c4c.db.dto.WebSessionDto;
import jp.co.c4c.service.CommonService;
import jp.co.c4c.service.MyService;
import jp.co.c4c.service.TopService;

@Controller
@RequestMapping("/top")
@SessionAttributes("webSessionDto")
public class TopController {

    @Autowired
    TopService topService;
    @Autowired
    CommonService commonService;
    @Autowired
    MyService myService;

    //�Z�b�V�����̃I�u�W�F�N�g����i�[���\�b�h
    @ModelAttribute("webSessionDto")
    public WebSessionDto setWebSessionDto(WebSessionDto webSessionDto) {
        return webSessionDto;
    }

    @RequestMapping
    public String init(@ModelAttribute("webSessionDto") WebSessionDto webSessionDto, Model model, TopForm form) {
        // ���O�C���`�F�b�N
        boolean isLogined = commonService.isLogined(webSessionDto);
        if (!isLogined)
            return "redirect:login";

        // �S�Ă̖{�̃��X�g��from�ɃZ�b�g
        form.setTopAndDetailDtoList(topService.getAllBooks());

        int memId = webSessionDto.getMemId();

        // ���O�C�����[�U�[�����C�ɓ��肵�Ă���{�̃��X�gform�ɃZ�b�g
        List<V_MyFavoriteBookDto> bk_T_FavoriteDtoList = topService.getFavoriteBooks(memId);
        List<Integer> myFavoriteBookIdList = bk_T_FavoriteDtoList.stream()
                .map(V_MyFavoriteBookDto::getBookId)
                .collect(Collectors.toList());
        form.setMyFavoriteBookIdList(myFavoriteBookIdList);

        // ���O�C�����[�U�[���Ǐ��ς݂̖{�̃��X�g���擾
        List<V_LendHistoryDto> bk_T_LendDtoList = topService.getlendedBooks(memId);
        List<Integer> myLendedBookIdList = bk_T_LendDtoList.stream()
                .map(V_LendHistoryDto::getBookId)
                .collect(Collectors.toList());
        form.setMyLendedBookIdList(myLendedBookIdList);

        // ���O�C�����[�U�[�̑ݏo�E�\�񗚗�S���擾
        List<V_MyLendHistoryDto> myPageDtoList = myService.getBooksByMemId(memId);

        List<V_MyLendHistoryDto> myLendingBookList = myPageDtoList.stream()
                .filter(obj -> obj.getLendStatus() == LendStatus.LENDING.getLendStatus())
                .collect(Collectors.toList());
        form.setMyLendingBookList(myLendingBookList);

        /* tagId�𕶎���ɕϊ� */
        for (int i = 0; i < form.getTopAndDetailDtoList().size(); i++) {
            String[] tagIds = form.getTopAndDetailDtoList().get(i).getTagIds().split(",");
            convertTag(tagIds);
            form.getTopAndDetailDtoList().get(i).setTagIds(String.join(",", tagIds));
        }

        // ���m�点���b�Z�[�W_�ݏo�����ʒm�p�̏����擾
        List<BK_T_LendDto> lendNewsList = topService.getLendNewsByMemId(memId);
        form.setLendNewsList(lendNewsList);

        int LendingCnt = form.getCountMyLendingBookList();
        model.addAttribute("LendingCnt", LendingCnt);

        // ���m�点���ǎ��Ԃ��擾
        BK_T_NewsReadDto newsReadAt = topService.getNewReadTime(memId);
        form.setReadTimeNews(newsReadAt.getReadAt());

        // ���m�点���ǃX�e�[�^�X���擾
        Date readTime = form.getReadTimeNews();
        boolean readStatus = topService.getRedStatus(readTime);

        model.addAttribute("readStatus", readStatus);

        //        // ���m�点���b�Z�[�W_�{���גʒm�̏����擾
        //        List<BK_M_BookDto> offerBookNewsList = topService.getofferBookNewsList(readTime);
        //        form.setLendNewsList(lendNewsList);

        //        // ���m�点���b�Z�[�W_�v�]�����{�̏��F�ʒm�̏����擾
        //        List<BK_M_BookDto> offerBookNewsList = topService.getofferBookNewsList(readTime);
        //        form.setLendNewsList(lendNewsList);

        // ���m�点���Ǐ�ԍX�V
        topService.updateReadTimeNews(memId);

        return "top";
    }

    /**
     * tagId�𕶎���ɕϊ����郁�\�b�h�i�쐬���j
     * @param strings
     * @return
     */
    public String[] convertTag(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            switch (strings[i]) {
            case "1":
                strings[i] = "Java"; // �萔�ɓ���ւ���
                break;
            case "2":
                strings[i] = "PHP";
                break;
            default:
                break;
            }
        }
        return strings;
    }

}
