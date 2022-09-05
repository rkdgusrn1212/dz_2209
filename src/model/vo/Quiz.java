package model.vo;

public class Quiz {
	int isbn;
	String quiz;
	String answer;

	public Quiz() {
		// TODO Auto-generated constructor stub
	}

	public Quiz(int isbn, String quiz, String answer) {
		super();
		this.isbn = isbn;
		this.quiz = quiz;
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Quiz [isbn=" + isbn + ", quiz=" + quiz + ", answer=" + answer + "]";
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getQuiz() {
		return quiz;
	}

	public void setQuiz(String quiz) {
		this.quiz = quiz;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
