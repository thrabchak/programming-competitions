
/*
 * In almost all cases use java.util.HashMap. Use this if a modifiable Hashtable is 
 * needed. Currently only uses ints as keys, eventually will expand to Strings.
 */
public class HashTable<T> {

	HashEntry[] dataArray;
	int count;
	
	public HashTable(int initialCapacity){
		dataArray = new HashEntry[initialCapacity];
		count = 0;
	}
	
	public int hash(int key){
		return key % dataArray.length;
	}
	
	/**
	 * Simple put operation using linear probing
	 * 
	 * @param key
	 * @param data
	 * @return
	 */
	public boolean put(int key, T data){
		if(count == dataArray.length)
			return false;
		int hashVal = hash(key);
		while(dataArray[hashVal] != null){
			hashVal++;
			if(hashVal == dataArray.length)
				hashVal = 0;
		}	
		dataArray[hashVal] = new HashEntry(key, data);
		count++;
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public void rehash(){
		HashEntry[] newDataArray = new HashEntry[dataArray.length*2];
		HashEntry[] oldDataArray = dataArray;
		dataArray = newDataArray;
		
		for(int i = 0; i < oldDataArray.length; i++)
			put(oldDataArray[i].key, (T)oldDataArray[i].data);
	}
	
	@SuppressWarnings("unchecked")
	public void rehash(int newSize){
		HashEntry[] newDataArray = new HashEntry[newSize];
		HashEntry[] oldDataArray = dataArray;
		dataArray = newDataArray;
		
		for(int i = 0; i < oldDataArray.length; i++)
			put(oldDataArray[i].key, (T)oldDataArray[i].data);
	}
	
	@SuppressWarnings("unchecked")
	public T get(int key){
		int hashVal = hash(key);
		
		while(dataArray[hashVal] != null && dataArray[hashVal].key != key){
			hashVal++;
			if(hashVal == dataArray.length)
				hashVal = 0;
		}	
		
		if(dataArray[hashVal] == null)
			return null;
		
		return (T)dataArray[hashVal].data;
	}
	
	public void clear(){
		for(int i = 0; i < dataArray.length; i++)
			dataArray[i] = null;
		count = 0;
	}
	
	public boolean containsKey(int key){
		return get(key) != null;
	}
	
	public int getSize(){
		return count;
	}
	
	public String toString(){
		StringBuffer output = new StringBuffer();
		
		output.append("     Key      |     Data\n");
		output.append("==============================\n");
		
		for( int i = 0; i < dataArray.length; i++)
			output.append(String.format("%-14s|%-14s",
							dataArray[i].key, 
							dataArray[i].data.toString()));
		
		return output.toString();
	}
	
}
