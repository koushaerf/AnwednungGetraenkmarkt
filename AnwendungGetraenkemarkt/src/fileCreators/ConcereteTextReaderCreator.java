package fileCreators;

public class ConcereteTextReaderCreator extends ReaderCreator{

	@Override
	public ReaderProduct factoryMethod() {
		
		return new ConcereteTextReaderProduct();
	}
	
	

}
