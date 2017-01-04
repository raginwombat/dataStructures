class hashTable{
	/*
	Hashtable impelemntation uses  hashtable with a chained data structure
	new hashes are appended to the list.
	*/
	private Hash hashTable [] = new Hash[13];



	public boolean insert(Hash h){
	/* Function to add hash to hash table. Apppends new hashes to end of bucket list
	@param: Hash to be inserted into the hastable
	@returns: boolean value if the insertion was sucessfull
	*/
		Hash oldTail;
		/*Bucket index provides the index for the set of nodes the new node will be attached do
		the code is broken out for clarity*/
		int bucketIndex =hashBucket(h.getHash());
		/* Links the bucket list together by appending the new hashes to the last node in the bucket.*/
		this.hashTable[ bucketIndex ].returnLastNode().setNext(h);

	return true;
	}


	public Hash[] delete(Hash [] hashes){
	/* Function to delete hashes form hash table
	@param: Hashes to be deleted from the has table
	@returns: The values that were deleted from the has table.
	*/
	return hashes;
	}


	public Hash[] get(Hash[] hashes){
	/* Function to return the data elements form the hashes provided
	@param: Hashes to mapped to values
	@returns: The values that correspond to the given hashes
	*/
		Hash hashRet[] = new Hash[hashes.length]; //hash array, might break
		for (int i=0; i< hashes.length; i++){
			
			// check if( this.hashIndex( hashes[i].getHash() ) != null){
			if( hashes[i].getHash()  != null){
				hashRet[i] = hashTable[1][ this.hashTable[hashes[i].getHash() ] ];

			}
		}
	return hashRet;
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
	}

	private int hashBucket(long hash){
		/* Function to return  compessed hash bucket based on entry hash.
		@param: Long with the hash for an entry
		@returns: Hash Bucket Entry
		*/
		return hash  % 13;
	}

	}
/*
	private String hashEncode(String firstName, String lastName){
		String hashedString = new String();
		int unique =0;

		hashedString = firstName.toUpperCase() + lastName.toUpperCase();

		do{
			if(this.hashIndex(hashString) == null){
				hashedTable = firstName + lastName+unique.toString;
				break;
			}
			hashedString = hashedString + unique.toString();
		} while(this.get(hashedString)!=null)	;

		return hashedString;

	}
*/
	private Integer hashIndex(String hashVal){
		for(int i=0; i<this.hashTable[0].length; i++){
			if(hashVal == hashTable[0][i].getHash()){
				return  new Integer(i);
			}
		}

		return null;
	}

	public int getHashIndex( K key){


	}
}