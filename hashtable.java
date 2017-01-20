class HashTable{
	/* RN
	Hashtable impelemntation uses  hashtable with a chained data structure
	new hashes are appended to the list.
	*/
	private Hash hashTable[];

	public HashTable(){
		/* RNCreate new hash table*/
		this.hashTable =  new Hash [13];

		/* RNInitiate Hash  Tables */
		for ( int i=0; i< hashTable.length; i++)
			this.hashTable[i] = new Hash();

	}

	private long hash(String firstName, String lastName){
		/* RN Function to generate hashes for entires based on name of entrant. 
		@param: First and  last name strings
		@returns: Hash as a string
		*/
		long hash =0;
		int g = 31;
		String name = firstName + lastName;
		for( int i =0 ; i< name.length(); i++ ){
			/* RN Mod Long.Max_Val compresses hash space reducing long overflows*/
			hash =  ((hash *g) + name.charAt(i)) % Long.MAX_VALUE;
		}
		return hash;
	}

	private int hashBucket(long hash){
		/* RN Function to return  compessed hash bucket based on entry hash.
		@param: Long with the hash for an entry
		@returns: Hash Bucket Entry
		*/

		/* RN Using Absolute value allows ignoring of negative hash values*/
		return (int) ((hash  % 13) <= 0 ? (0-hash%13): (hash%13));
	}


	public boolean insert(Hash h){
	/* RN Function to add hash to hash table. Apppends new hashes to end of bucket list
	@param: Hash to be inserted into the hastable
	@returns: boolean value if the insertion was sucessfull
	*/
		
		/* RNBucket index provides the index for the set of nodes the new node will be attached do
		the code is broken out for clarity*/
		int bucketIndex = this.hashBucket( h.getHash());
		
		return this.hashTable[bucketIndex].add(h);
	}


	public boolean delete(Hash h){
	/* RN Function to delete hashes form hash table.
	Uses java reference passing ot manipulate hash bucket using alias checkHash.
	@param: Hashes to be deleted from the has table
	@returns: The values that were deleted from the has table.
	*/
		Hash checkHash, prevHash;
		int bucketIndex = this.hashBucket( h.getHash());
		
		
		prevHash  = hashTable[ bucketIndex];
		checkHash = prevHash.getNext();

		//RN Case: Hash found in first node have to reset bucket Index
		if(prevHash.getHash() == h.getHash()){
			hashTable[bucketIndex] = checkHash;
			return true;
		}

		//RN Check for hash in rest of hashes
		while( prevHash.getHash() != h.getHash() && checkHash.getHash() != h.getHash()  && checkHash.getNext() != null ){
			prevHash = checkHash;
			checkHash = checkHash.getNext();
		}

		//RN Case: Hash found someohere in between
		if(checkHash.getHash() == h.getHash()){
			prevHash.setNext( checkHash.getNext());
			return true;
		}
	
		/* RNCase: hash not found by last node equilavent check to 
		if(prevHash.getHash() != h.getHash() && checkHash.getHash() != h.getHash() 
			&& checkHash == prevHash.returnLastNode())
		*/


		return false;
		
	}



	public Hash get(Hash h){
	/* RN Function to return the data elements form the hashes provided
	@param: Hashes to mapped to values
	@returns: The values that correspond to the given hashes
	*/
		Hash checkHash;
		
		int bucketIndex = this.hashBucket( h.getHash());
		return this.lookUp( h.getHash(), bucketIndex);
	}

	private Hash lookUp(long hashVal, int bucketIndex) {
		Hash checkHash;
		checkHash = hashTable[ bucketIndex];
		while(checkHash != null && checkHash.getHash() != hashVal && checkHash.getNext() != null){
			checkHash = checkHash.getNext();
		}

		if(checkHash != null &&checkHash.getHash() == hashVal ){
			//RN checkHash.print();
			return checkHash;
		}
		
		else
			return null;

	}
	

	public void nameLookUp(String firstName, String lastName){
		long hash = this.hash(firstName, lastName);
		if( this.lookUp( hash , this.hashBucket(hash)) != null)
			System.out.println( "Found " +this.lookUp( hash , this.hashBucket(hash)).getName()+" hash is:"+hash);
	
		else
			System.out.println(firstName + " "+ lastName+" not found.");


	}

	public void nameDelete(String firstName, String lastName){
		long hash =  this.hash(firstName, lastName);
		Hash checkHash = this.lookUp( hash , this.hashBucket(hash));
		if( checkHash != null && this.delete(checkHash) == true)
			System.out.println("Node deleted for "+ firstName+ " "+lastName);

		else
			System.out.println("Node not deleted for "+ firstName+ " "+lastName);
	}

	public void add(String firstName, String lastName,  String phone, String email){
		Hash h = new Hash( this.hash(firstName, lastName), firstName, lastName, phone, email);
		if(this.insert(h) == true)
			System.out.println("Added "+ firstName+ " "+lastName);

		else
			System.out.println("Node not added for "+ firstName+ " "+lastName);;
	}

	public void printHashes(){
		for (int i=0; i< hashTable.length; i++){
			System.out.println("Hash Index: "+ i );
			hashTable[i].printAll();
		}

	}

}