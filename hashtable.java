class HashTable{
	/*
	Hashtable impelemntation uses  hashtable with a chained data structure
	new hashes are appended to the list.
	*/
	private Hash hashTable[];

	public HashTable(){
		Hash [] hashTable =  new Hash [13];

	}

	private long hash(String firstName, String lastName){
		/* Function to generate hashes for entires based on name of entrant. 
		@param: First and  last name strings
		@returns: Hash as a string
		*/
		int hash =0;
		int g = 31;
		String name = firstName + lastName;
		for( int i =0 ; i< name.length(); i++ ){
			hash = hash *g + name.charAt(i);

		}
		//Ddebug: System.out.println(hash);
		return hash;
	}

	private int hashBucket(long hash){
		/* Function to return  compessed hash bucket based on entry hash.
		@param: Long with the hash for an entry
		@returns: Hash Bucket Entry
		*/
		return (int) hash  % 13;
	}


	public boolean insert(Hash h){
	/* Function to add hash to hash table. Apppends new hashes to end of bucket list
	@param: Hash to be inserted into the hastable
	@returns: boolean value if the insertion was sucessfull
	*/
	
		/*Bucket index provides the index for the set of nodes the new node will be attached do
		the code is broken out for clarity*/
		int bucketIndex = this.hashBucket( h.getHash());
		 System.out.println(bucketIndex); //Debug
		/* Links the bucket list together by appending the new hashes to the last node in the bucket.*/
		hashTable[0].print();
		this.hashTable[ bucketIndex ].returnLastNode().setNext(h);

	return true;
	}


	public void delete(Hash h){
	/* Function to delete hashes form hash table.
	Uses java reference passing ot manipulate hash bucket using alias checkHash.
	@param: Hashes to be deleted from the has table
	@returns: The values that were deleted from the has table.
	*/
		Hash checkHash;
		
		int bucketIndex = this.hashBucket( h.getHash());
		checkHash = hashTable[ bucketIndex];
		while( checkHash.getNext().getHash() != h.getHash()  && checkHash.getNext() != null ){
			checkHash = checkHash.getNext();
		}
		/*!! Need to double check if next.next == null thenthe null will get passed and bet set, 
		effceitly making this a tail deletion. need to ensure won't throw ref error bc of null 
		should be hanlded by the null check above*/
		if(checkHash.getNext().getHash() == h.getHash()){
			checkHash.setNext(checkHash.getNext().getNext());
		}
		
			
		


	}



	public Hash get(Hash h){
	/* Function to return the data elements form the hashes provided
	@param: Hashes to mapped to values
	@returns: The values that correspond to the given hashes
	*/
		Hash checkHash;
		
		int bucketIndex = this.hashBucket( h.getHash());
		return this.lookUp( h.getHash(), bucketIndex);

	/*
		checkHash = hashTable[ bucketIndex];
		while( checkHash.getHash() != h.getHash() && checkHash.getNext() != null){
			checkHash = checkHash.getNext();
		}
		if(checkHash.getHash() == h.getHash() ){
			checkHash.print();
			return checkHash.getNext();
		}
		
		else
			return null;
			*/
	}

	private Hash lookUp(long hashVal, int bucketIndex) {
		Hash checkHash;
		checkHash = hashTable[ bucketIndex];
		while( checkHash.getHash() != hashVal && checkHash.getNext() != null){
			checkHash = checkHash.getNext();
		}
		if(checkHash.getHash() == hashVal ){
			//checkHash.print();
			return checkHash;
		}
		
		else
			return null;

	}
	

	public Hash nameLookUp(String firstName, String lastName){
		long hash = this.hash(firstName, lastName);
		return lookUp( hash , this.hashBucket(hash));

	}

	public void nameDelete(String firstName, String lastName){
		long hash =  this.hash(firstName, lastName);

		this.delete( this.lookUp( hash , this.hashBucket(hash))  );
	}

	public Hash add(String firstName, String lastName,  String phone, String email){
		Hash h = new Hash( this.hash(firstName, lastName), firstName, lastName, phone, email);
		this.insert(h);

		return h;
	}

}