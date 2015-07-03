package test;
class Apple
{
	public Apple(){}
	public Apple(int id,int price){
		this.id=id;
		this.price=price;
	}
	
	private int id;
	private int price;

	public int getId()
	{return id;}

	public void setId(int id)
	{this.id = id;}

	public int getPrice()
	{return price;}

	public void setPrice(int price)
	{this.price = price;}
}