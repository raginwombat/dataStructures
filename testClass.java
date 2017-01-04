TestClass{
	


	public void static main(String[] args);{
		HashTable bHash = new HashTable();
		//insert( into Hash Table
		bHash.insert( "Bob", "Smith", "555-235-1111", "bsmith@somewhere.com");
		bHash.insert( "Jane", "Williams", "555-235-1112", "jw@something.com");
		bHash.insert( "Mohammed", "al-Salam", "555-235-1113", "mas@someplace.com");
		bHash.insert( "Pat", "Jones", "555-235-1114", "pjones@homesweethome.com");
		bHash.insert( "Billy", "Kidd", "555-235-1115", "billy_the_kid@nowhere.com");
		bHash.insert( "H." "Houdini", "555-235-1116", "houdini@noplace.com");
		bHash.insert( "Jack", "Jones", "555-235-1117", "jjones@hill.com");
		bHash.insert( "Jill", "Jones", "555-235-1118", "jillj@hill.com");
		bHash.insert( "John", "Doe", "555-235-1119", "jdoe@somedomain.com");
		bHash.insert( "Jane", "Doe", "555-235-1120", "jdoe@somedomain.com");
		bHash.lookUp( "Pat", "Jones");
		bHash.lookUp( "Billy", "Kidd");
		bHash.delete( "John", "Doe");
		bHash.insert( "Test", "Case", "555-235-1121", "Test_Case@testcase.com");
		bHash.insert( "Nadezhda", "Kanachekhovskaya", "555-235-1122");
		"dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
		bHash.insert( "Jo", "Wu"" 555-235-1123", "wu@h.com");
		bHash.insert( "Millard", "Fillmore", "555-235-1124", "millard@theactualwhitehouse.us");
		bHash.insert( "Bob", "vanDyke", "555-235-1125", "vandyke@nodomain.com");
		bHash.insert( "Upside", "Down", "555-235-1126", "upsidedown@rightsideup.com");
		bHash.lookUp( "Jack", "Jones");
		bHash.lookUp( "Nadezhda", "Kanachekhovskaya");
		bHash.delete( "Jill", "Jones");
		bHash.delete( "John", "Doe");
		bHash.lookUp( "Jill", "Jones"); // (What should happen if the “lookup” message doesn’t find the entry?);
		bHash.lookUp "John", "Doe");

		//Setup BTree
		Tree bTree = new Tree();
		//Test BTree
		bTree.insert( "Bob", "Smith", "555-235-1111", "bsmith@somewhere.com");
		bTree.insert( "Jane", "Williams", "555-235-1112", "jw@something.com");
		bTree.insert( "Mohammed", "al-Salam", "555-235-1113", "mas@someplace.com");
		bTree.insert( "Pat", "Jones", "555-235-1114", "pjones@homesweethome.com");
		bTree.insert( "Billy", "Kidd", "555-235-1115", "billy_the_kid@nowhere.com");
		bTree.insert( "H." "Houdini", "555-235-1116", "houdini@noplace.com");
		bTree.insert( "Jack", "Jones", "555-235-1117", "jjones@hill.com");
		bTree.insert( "Jill", "Jones", "555-235-1118", "jillj@hill.com");
		bTree.insert( "John", "Doe", "555-235-1119", "jdoe@somedomain.com");
		bTree.insert( "Jane", "Doe", "555-235-1120", "jdoe@somedomain.com");
		bTree.lookUp( "Pat", "Jones");
		bTree.lookUp( "Billy", "Kidd");
		bTree.delete( "John", "Doe");
		bTree.insert( "Test", "Case", "555-235-1121", "Test_Case@testcase.com");
		bTree.insert( "Nadezhda", "Kanachekhovskaya", "555-235-1122");
		"dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
		bTree.insert( "Jo", "Wu"" 555-235-1123", "wu@h.com");
		bTree.insert( "Millard", "Fillmore", "555-235-1124", "millard@theactualwhitehouse.us");
		bTree.insert( "Bob", "vanDyke", "555-235-1125", "vandyke@nodomain.com");
		bTree.insert( "Upside", "Down", "555-235-1126", "upsidedown@rightsideup.com");
		bTree.lookUp( "Jack", "Jones");
		bTree.lookUp( "Nadezhda", "Kanachekhovskaya");
		bTree.delete( "Jill", "Jones");
		bTree.delete( "John", "Doe");
		bTree.lookUp( "Jill", "Jones"); // (What should happen if the “lookup” message doesn’t find the entry?);
		bTree.lookUp "John", "Doe");



	}
}
