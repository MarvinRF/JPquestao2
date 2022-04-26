package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import entities.Data;

public class DataTest {

	@Test
	@DisplayName("verifica se a data foi criada corretamente")
	public void constructorTest_CreateData_DataCreated() {
		Data data = new Data("01/01/0001");
	}
	
	@Test
	@DisplayName("caso a data seja inválida, deve ser definida como 01/01/0001")
	public void constructorTest_dataIsInvalid_DataDefinedHow_01_01_0001() {
		Data data = new Data("ABC");
		assertEquals("1/1/1",data.getData());
	}
	
	@Test
	@DisplayName("caso as datas sejam identicas devera ser retornado 0")
	public void comparaTest_equalDates_returnZero(){
		Data data1 = new Data("16/04/2022");
		Data data2 = new  Data("16/04/2022");
		assertEquals(0,data1.compara(data2));
		
	}
	@Test
	@DisplayName("caso a data do objeto seja maior do que a data do parametro devera ser retornado 1")
	public void comparaTest_SecondDateBiggerThanFirst_returnOnes(){
		Data data1 = new Data("17/04/2022");
		Data data2 = new  Data("15/04/2022");
		assertEquals(1,data1.compara(data2));
		
	}
	@Test
	@DisplayName("caso a data do objeto seja menor do que a data do parametro devera ser retornado -1")
	public void comparaTest_SecondDateSmallerThanFirst_returnMinusOne(){
		Data data1 = new Data("16/04/2022");
		Data data2 = new  Data("17/04/2022");
		assertEquals(-1,data1.compara(data2));
	}
	@Test
	@DisplayName("caso seja o primeiro mes do ano deve ser retornado janeiro")
	public void getMesExtensoTest_FirstMonth_january(){
		Data data1 = new Data("16/01/2022");
		assertEquals("janeiro",data1.getMesExtenso());
	}
	@Test
	@DisplayName("caso o ano seja bissexto deve ser retornado true")
	public void getIsBissextoTest_2024_True(){
		Data data1 = new Data("16/01/2024");
		assertTrue(data1.isBissexto());
	}
	
	@Test
	@DisplayName("caso o ano nao seja bissexto deve ser retornado false")
	public void getIsBissextoTest_2022_False(){
		Data data1 = new Data("16/01/2022");
		assertFalse(data1.isBissexto());
	}
}
