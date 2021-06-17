package gourmet.game.lambda;

import javax.swing.*;
import java.util.function.Consumer;

public class Question {

    protected JFrame jFrameParent;
    protected Question questionParent;
    protected String description;
    private Question yes;
    private Question no;

    protected Question(final JFrame jFrameParent, String description) {
        this.jFrameParent = jFrameParent;
        this.description = description;
    }

    protected void ask(Consumer<Question> questionParentReferenceCallback) {
        final boolean responseYes = showQuestion("Pergunta...");
        if (responseYes) {
            this.yes.ask(newQuestion -> this.setYes(newQuestion));
        } else {
            this.no.ask(newQuestion -> this.setNo(newQuestion));
        }
    }

    protected void setYes(Question yes) {
        this.yes = yes;
        this.yes.questionParent = this;
    }

    protected void setNo(Question no) {
        this.no = no;
        this.no.questionParent = this;
    }

    protected boolean showQuestion(final String title) {
        return JOptionPane.showConfirmDialog(jFrameParent, "O prato que voc\u00ea pensou \u00e9 " + description + "?", title, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }
}
