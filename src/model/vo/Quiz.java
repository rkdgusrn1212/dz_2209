package model.vo;

public class Quiz {
    int quizId;
    int isbn;
    String question;
    String answer;

    public Quiz() {
        // TODO Auto-generated constructor stub
    }

    public Quiz(int quizId, int isbn, String question, String answer) {
        super();
        this.quizId = quizId;
        this.isbn = isbn;
        this.question = question;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Quiz [quizId=" + quizId + ", isbn=" + isbn + ", question=" + question + ", answer=" + answer + "]";
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    
}
