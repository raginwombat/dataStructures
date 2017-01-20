class TreeTestClass{


	public  static void main(String[] args){
		// RN Setup BTree
		Tree bTree = new Tree();
		// RN Test BTree
		bTree.add( "Bob", "Smith", "555-235-1111", "bsmith@somewhere.com");// RN found
		bTree.add( "Jane", "Williams", "555-235-1112", "jw@something.com");// RN found
		bTree.add( "Mohammed", "al-Salam", "555-235-1113", "mas@someplace.com"); // RN found
		bTree.add( "Pat", "Jones", "555-235-1114", "pjones@homesweethome.com");// RN found
		bTree.add( "Billy", "Kidd", "555-235-1115", "billy_the_kid@nowhere.com");// RN found
		bTree.add( "H.", "Houdini", "555-235-1116", "houdini@noplace.com");// RN found
		bTree.add( "Jack", "Jones", "555-235-1117", "jjones@hill.com");// RN found
		bTree.add( "Jill", "Jones", "555-235-1118", "jillj@hill.com");// RN found
		bTree.add( "John", "Doe", "555-235-1119", "jdoe@somedomain.com");// RN found
		bTree.add( "Jane", "Doe", "555-235-1120", "jdoe@somedomain.com");// RN found
		bTree.nameLookUp( "Pat", "Jones");
		bTree.nameLookUp( "Billy", "Kidd");
		bTree.nameDelete( "John", "Doe");
		bTree.add( "Test", "Case", "555-235-1121", "Test_Case@testcase.com");// RN found
		bTree.add( "Nadezhda", "Kanachekhovskaya", "555-235-1122",
			"dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");// RN found
		bTree.add( "Jo", "Wu", "555-235-1123", "wu@h.com");// RN found
		bTree.add( "Millard", "Fillmore", "555-235-1124", "millard@theactualwhitehouse.us");// RN foundv
		bTree.add( "Bob", "vanDyke", "555-235-1125", "vandyke@nodomain.com");// RN found
		bTree.add( "Upside", "Down", "555-235-1126", "upsidedown@rightsideup.com");// RN found
		bTree.nameLookUp( "Jack", "Jones");
		bTree.nameLookUp( "Nadezhda", "Kanachekhovskaya");
		bTree.nameLookUp( "Jill", "Jones"); // RN  (What should happen if the “lookup” message doesn’t find the entry?);
		bTree.nameLookUp( "John", "Doe");
		bTree.nameDelete( "Jill", "Jones");
		bTree.nameDelete( "John", "Doe");
		bTree.nameLookUp( "Jill", "Jones"); // RN  (What should happen if the “lookup” message doesn’t find the entry?);
		bTree.nameLookUp( "John", "Doe");
		// RN bTree.printAll();

	}
}
