package qu10_Bridge;

public class BigWheel extends Car {
    
	
	public BigWheel(Product product, String carType) {
        super(product, carType);
        //throw new UnsupportedOperationException();
    }

    @Override
    public void assemble() {
        System.out.println("Assembling " + super.product.productName() + " for " + super.carType);
    	//throw new UnsupportedOperationException();
    }

    @Override
    public void produceProduct() {
    	product.produce();
    	//throw new UnsupportedOperationException();
    }
}