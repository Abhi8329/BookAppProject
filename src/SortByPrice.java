import java.util.Comparator;

public class SortByPrice implements Comparator<BookDetails>{

	@Override
	public int compare(BookDetails b1, BookDetails b2) {
		// TODO Auto-generated method stub
		return Float.compare(b1.getPrice(), b2.getPrice());
	}

}
