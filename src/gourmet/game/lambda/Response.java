package gourmet.game.lambda;

import javax.swing.*;
import java.util.function.Consumer;

public class Response extends Question {

    protected Response(JFrame jFrameParent, String description) {
        super(jFrameParent, description);
    }

    @Override
    protected void ask(Consumer<Question> questionParentReferenceCallback) {
        final boolean responseYes = showQuestion("Hmmm...");
        if (responseYes) {
            JOptionPane.showMessageDialog(jFrameParent, "Acertei!!!", "Uhull!!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            final String newResponseDescription = JOptionPane.showInputDialog(jFrameParent, "Qual prato voc\u00ea pensou?", "Desisto!!!", JOptionPane.QUESTION_MESSAGE);
            if (isNullOrEmpty(newResponseDescription)) { //validating the input
                return;
            }

            final String newDiferenceDescription = JOptionPane.showInputDialog(jFrameParent, newResponseDescription + " \u00e9 _______ mas " + this.description + " n\u00e3o.", "Complete com uma diferen\u00e7a...", JOptionPane.QUESTION_MESSAGE);
            if (isNullOrEmpty(newDiferenceDescription)) {//validating the input
                return;
            }

            //creating the new question
            final Question newQuestion = new Question(jFrameParent, newDiferenceDescription);
            questionParentReferenceCallback.accept(newQuestion);
            newQuestion.setYes(new Response(jFrameParent, newResponseDescription)); // new response description
            newQuestion.setNo(this); // current response
        }
    }

    private static boolean isNullOrEmpty(String value) {
        return value == null || "".equals(value.trim());
    }
}
