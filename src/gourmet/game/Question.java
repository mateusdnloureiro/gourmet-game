package gourmet.game;

import javax.swing.*;

public class Question {

    protected JFrame jFrameParent;
    protected Question questionParent;
    protected String description;
    protected Question yes;
    protected Question no;

    protected Question(final JFrame jFrameParent, String description) {
        this.jFrameParent = jFrameParent;
        this.description = description;
    }

    protected void ask() {
        final boolean responseYes = showQuestion("Pergunta...");
        if (responseYes) {
            this.yes.ask();
        } else {
            this.no.ask();
        }
    }

    protected void setYes(Question yes) {
        this.yes = yes;
        this.yes.questionParent = this;
    }

    protected Question getYes() {
        return this.yes;
    }

    protected void setNo(Question no) {
        this.no = no;
        this.no.questionParent = this;
    }

    protected boolean showQuestion(final String title) {
        return JOptionPane.showConfirmDialog(jFrameParent, "O prato que voc\u00ea pensou \u00e9 " + description + "?", title, 0) == 0;
    }
}
