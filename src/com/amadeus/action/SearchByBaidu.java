package com.amadeus.action;

import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.CaretModel;
import org.apache.commons.lang3.StringUtils;

import javax.swing.ImageIcon;

public class SearchByBaidu extends AnAction {

    public SearchByBaidu(){
        super(null, null, new ImageIcon(
                SearchByBaidu.class.getClassLoader().getResource("icon/icon.png")
        ));
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        String baidu = "https://www.baidu.com/s?wd=";
        CaretModel caretModel = e.getData(LangDataKeys.EDITOR).getCaretModel();
        Caret currentCaret = caretModel.getCurrentCaret();
        String selectedText = currentCaret.getSelectedText().trim();
        try{
            selectedText = selectedText.replaceAll(" ", "+");
        }catch (NullPointerException ex){
            System.out.println("Text can't be empty" + ex.getMessage());
        }
        if (StringUtils.isNotBlank(selectedText)){
            BrowserUtil.browse(baidu + selectedText);
        }else {
            BrowserUtil.browse(baidu);
        }
    }
}
