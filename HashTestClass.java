class HashTestClass{


	public  static void main(String[] args){
		HashTable bHash = new HashTable();
		//add( into Hash Table
		System.out.println("Starting tests for Hash Table");
		bHash.add( "Jane", "Williams", "555-235-1112", "jw@something.com"); 
		bHash.add( "Bob", "Smith", "555-235-1111", "bsmith@somewhere.com");
		bHash.add( "Mohammed", "al-Salam", "555-235-1113", "mas@someplace.com");
		bHash.add( "Pat", "Jones", "555-235-1114", "pjones@homesweethome.com"); 
		bHash.add( "Billy", "Kidd", "555-235-1115", "billy_the_kid@nowhere.com"); 
		bHash.add( "H.", "Houdini", "555-235-1116", "houdini@noplace.com"); 
		bHash.add( "Jack", "Jones", "555-235-1117", "jjones@hill.com"); 
		bHash.add( "Jill", "Jones", "555-235-1118", "jillj@hill.com"); 
		bHash.add( "Jane", "Doe", "555-235-1120", "jdoe@somedomain.com");
		bHash.nameLookUp( "Pat", "Jones");
		bHash.nameLookUp( "Billy", "Kidd");
		bHash.add( "John", "Doe", "555-235-1119", "jdoe@somedomain.com"); 
		bHash.nameDelete( "John", "Doe");
		bHash.add( "Test", "Case", "555-235-1121", "Test_Case@testcase.com");
		bHash.add( "Nadezhda", "Kanachekhovskaya", "555-235-1122",
			"dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
		bHash.add( "Jo", "Wu", "555-235-1123", "wu@h.com");
		bHash.add( "Millard", "Fillmore", "555-235-1124", "millard@theactualwhitehouse.us");
		bHash.add( "Bob", "vanDyke", "555-235-1125", "vandyke@nodomain.com");
		bHash.add( "Upside", "Down", "555-235-1126", "upsidedown@rightsideup.com");
		bHash.nameLookUp( "Jack", "Jones");
		bHash.nameLookUp( "Nadezhda", "Kanachekhovskaya");
		bHash.nameDelete( "Jill", "Jones");
		bHash.nameDelete( "John", "Doe");
		bHash.nameLookUp( "Jill", "Jones"); // (What should happen if the “lookup” message doesn’t find the entry?);
		bHash.nameLookUp( "John", "Doe");

	}
}
