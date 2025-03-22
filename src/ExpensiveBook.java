import java.util.Comparator;

public class ExpensiveBook implements Comparator<BookDetails>{

	@Override
	public int compare(BookDetails b1, BookDetails b2) {
		// TODO Auto-generated method stub
		return Double.compare(b1.getPrice(), b2.getPrice());
	}

}
