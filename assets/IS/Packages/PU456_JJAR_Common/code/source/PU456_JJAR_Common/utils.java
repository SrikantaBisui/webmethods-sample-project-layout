package PU456_JJAR_Common;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2017-08-07 07:05:19 EDT
// -----( ON-HOST: itsusralsp03487.jnj.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import com.wm.data.IData;
import com.wm.data.IDataCursor;
import com.wm.data.IDataUtil;
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void addDaysToDate (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(addDaysToDate)>> ---
		// @sigtype java 3.5
		// [i] field:0:optional year
		// [i] field:0:optional month
		// [i] field:0:optional day
		// [i] field:0:required daysToAdd
		// [o] field:0:optional yearOut
		// [o] field:0:optional monthOut
		// [o] field:0:optional dayOut
		IDataCursor pipelineCursor = pipeline.getCursor();
				String	year = IDataUtil.getString( pipelineCursor, "year" );
				String  month = IDataUtil.getString( pipelineCursor, "month");
				String  day = IDataUtil.getString( pipelineCursor, "day");
				String  daysToAdd = IDataUtil.getString( pipelineCursor, "daysToAdd");
				
				
				/*String  month = Integer.toString(monthInt - 1);
				String	day = IDataUtil.getString( pipelineCursor, "day" );
				String	yearOut= IDataUtil.getString( pipelineCursor, "daysToAdd" );*/
			pipelineCursor.destroy();
			 //String[] monthNames = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
			
				GregorianCalendar myDate = new GregorianCalendar();
				myDate.set(Integer.parseInt(year), Integer.parseInt(month)-1, Integer.parseInt(day));
				myDate.add(Calendar.DATE , Integer.parseInt(daysToAdd));
				//myDate.roll(Calendar.DAY_OF_YEAR, false);
				String yearAOut = Integer.toString(myDate.get(Calendar.YEAR));
				String monthOut = Integer.toString(myDate.get(Calendar.MONTH) +1);
				
				String dayOut = Integer.toString(myDate.get(Calendar.DATE));
				//String outDate = dayOut + "-"+ monthOut+ "-"+yearAOut;
			// pipeline
				IDataCursor pipelineCursor_1 = pipeline.getCursor();
				IDataUtil.put( pipelineCursor_1, "yearOut", yearAOut);
				IDataUtil.put( pipelineCursor_1, "monthOut", monthOut );
				IDataUtil.put( pipelineCursor_1, "dayOut", dayOut );
				
			
			
			pipelineCursor_1.destroy();
			
			
		// --- <<IS-END>> ---

                
	}



	public static final void calculateDaysOfMonth (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(calculateDaysOfMonth)>> ---
		// @sigtype java 3.5
		// [i] field:0:required year
		// [i] field:0:required monthNum
		// [o] field:0:required days
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		
			String	year = IDataUtil.getString( pipelineCursor, "year" );
			
			
			String	monthNum = IDataUtil.getString( pipelineCursor, "monthNum" );
		
			Integer yearInt = Integer.parseInt(year);
			Integer monthNumInt = Integer.parseInt(monthNum);
			//int days;
			String days ="";
			
			if (monthNumInt==2) 
		    {
		     if ( (yearInt % 4 == 0) && (yearInt % 400 == 0) && !(yearInt  % 100 == 0) )
		            days = "29";
		        else
		            days = "28";
		    }
		else if (monthNumInt==1|| monthNumInt==3 || monthNumInt==5 || monthNumInt==7 || monthNumInt==8 
		            || monthNumInt==10 || monthNumInt==12)
			days = "31";
		
		else
			days = "30";
		
		// pipeline
		
		IDataUtil.put( pipelineCursor, "days", days );
		
			
		// --- <<IS-END>> ---

                
	}



	public static final void compareDates (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(compareDates)>> ---
		// @sigtype java 3.5
		// [i] field:0:required dateString1
		// [i] field:0:required dateFormat1
		// [i] field:0:required dateString2
		// [i] field:0:required dateFormat2
		// [o] field:0:required result
		IDataCursor idcPipeline = pipeline.getCursor();
		String ds1 = "";
		String ds2 = "";
		String df1 = "";
		String df2 = "";
		if (idcPipeline.first("dateString1"))
		  ds1 = (String) idcPipeline.getValue();
		
		if (idcPipeline.first("dateString2"))
		  ds2 = (String) idcPipeline.getValue();
		
		if (idcPipeline.first("dateFormat1"))
		  df1 = (String) idcPipeline.getValue();
		
		if (idcPipeline.first("dateFormat2"))
		  df2 = (String) idcPipeline.getValue();
		
		if (df1.equals("") || df2.equals(""))
		  throw new ServiceException("Date formats must be specified");
		
		if (ds1.equals("") || ds2.equals(""))
		  throw new ServiceException("Dates cannot be null");
		
		SimpleDateFormat sdf1 = new SimpleDateFormat(df1);
		SimpleDateFormat sdf2 = new SimpleDateFormat(df2);
		Date d1 = null;
		Date d2 = null;
		try
		{
		  d1 = sdf1.parse(ds1);
		  d2 = sdf2.parse(ds2);
		}
		catch (Exception e)
		{
		  throw new ServiceException(e.toString());
		}
		
		boolean isafter = d1.after(d2);
		boolean isbefore = d2.after(d1);
		if (isafter)
		{
		  idcPipeline.insertAfter("result", "1");
		}
		else if (isbefore)
		{
		  idcPipeline.insertAfter("result", "-1");
		}
		else
		// dates are equal
		{
		  idcPipeline.insertAfter("result", "0");
		  
		}
		
		idcPipeline.destroy();
			
		// --- <<IS-END>> ---

                
	}



	public static final void compareDocList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(compareDocList)>> ---
		// @sigtype java 3.5
		// [i] record:1:required oldDocList
		// [i] record:1:required newDocList
		// [o] field:0:required compare
		String isDocistChanged = "";
		ArrayList<String> compareList = new ArrayList<String>();
		ArrayList<String> oldList = new ArrayList<String>();
		String CompareString = "";
		IDataCursor pipelineCursor = pipeline.getCursor(); 
		IData[] oldDocList = IDataUtil.getIDataArray( pipelineCursor, "oldDocList" ); 
		
		IData[] newDocList = IDataUtil.getIDataArray( pipelineCursor, "newDocList" ); 
		boolean isPresent = false;
		
		//if(newDocList!=null && oldDocList!=null){
			
				if(newDocList==null || oldDocList ==null || (newDocList.length!=oldDocList.length)){
					if (newDocList!=null) {
						for (int i = 0; i < newDocList.length; i++) {
							IData tempNewDoc = newDocList[i];
							IDataCursor _datacursor = tempNewDoc.getCursor();
							//String key;
							String name;
		
							while (_datacursor.hasMoreData()) {
								_datacursor.next();
								
								name = IDataUtil.getString(_datacursor, "value");
								compareList.add(name);
								
							}
						}
					}
					if (oldDocList!=null) {
						for (int i = 0; i < oldDocList.length; i++) {
							IData tempOldDoc = oldDocList[i];
							IDataCursor _datacursor1 = tempOldDoc.getCursor();
							//String key;
							String name;
		
							while (_datacursor1.hasMoreData()) {
								_datacursor1.next();
								
							
								name = IDataUtil.getString(_datacursor1, "value");
								oldList.add(name);
								
							}
						}
					}
					
				}
				else{
				
				//check if new country is added in old list
				for(int i =0;i<newDocList.length;i++){
					isPresent = false;
					IData tempNewDoc= newDocList[i];
					IDataCursor _datacursor = tempNewDoc.getCursor() ;
					//String key;
					String name;
					
					while(_datacursor.hasMoreData()){
						_datacursor.next();
						
						name = IDataUtil.getString(_datacursor, "value");
						
						//if (oldDocList!=null) {
							String oldValue="";
							oldList = new ArrayList<String>();
							for (int j = 0; j < oldDocList.length; j++) {
								IData tempOld = oldDocList[j];
								IDataCursor _datacursorOld = tempOld.getCursor();
								oldValue = (String) IDataUtil.get(
										_datacursorOld,  "value");
								oldList.add(oldValue);
								if (name.equalsIgnoreCase(oldValue)) {
									isPresent = true;
									
								}
							}
							
						//}
						if(!isPresent){
							compareList.add(name);
						}
					}
					
					}
					if(compareList.size()==0){
						oldList = new ArrayList<>();
					}
				}
			Iterator<String> it =  compareList.iterator();
			String isDocistChangedForNew = "";
			  while(it.hasNext()){
				  String temp  = it.next();
				  isDocistChangedForNew = isDocistChangedForNew +temp+", " ;
			  }
			  if(isDocistChangedForNew.length()==0){
				  isDocistChangedForNew = "(BLANK)";
			  }
			 String isDocistChangedForOld = "";
				isDocistChanged = isDocistChangedForNew;
				Iterator<String> it1 = oldList.iterator();
				while (it1.hasNext()) {
					String temp = it1.next();
					isDocistChangedForOld = isDocistChangedForOld + temp + ", ";
				}
			
				 if(isDocistChangedForOld.length()==0){
					 isDocistChangedForOld = "(BLANK)";
				  }
				if(isDocistChangedForNew.equalsIgnoreCase("(BLANK)") && isDocistChangedForOld.equalsIgnoreCase("(BLANK)") ){
				 isDocistChanged = "";
				}else{
					isDocistChanged = isDocistChanged+ " from " + isDocistChangedForOld;
				}
			
		IDataCursor pipelineCursor_1 = pipeline.getCursor();  
		 
		IDataUtil.put( pipelineCursor_1, "compare", isDocistChanged);  
		pipelineCursor_1.destroy();  
		// --- <<IS-END>> ---

                
	}



	public static final void compareDocList_1 (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(compareDocList_1)>> ---
		// @sigtype java 3.5
		// [i] record:1:required oldDocList
		// [i] record:1:required newDocList
		// [o] field:0:required compare
		String isDocistChanged = "";
		ArrayList<String> compareList = new ArrayList<String>();
		ArrayList<String> oldList = new ArrayList<String>();
		String CompareString = "";
		IDataCursor pipelineCursor = pipeline.getCursor(); 
		IData[] oldDocList = IDataUtil.getIDataArray( pipelineCursor, "oldDocList" ); 
		
		IData[] newDocList = IDataUtil.getIDataArray( pipelineCursor, "newDocList" ); 
		boolean isPresent = false;
		
		//if(newDocList!=null && oldDocList!=null){
			
				if(newDocList==null || oldDocList ==null || (newDocList.length!=oldDocList.length)){
					if (newDocList!=null) {
						for (int i = 0; i < newDocList.length; i++) {
							IData tempNewDoc = newDocList[i];
							IDataCursor _datacursor = tempNewDoc.getCursor();
							String key;
							String name;
		
							while (_datacursor.hasMoreData()) {
								_datacursor.next();
								key = _datacursor.getKey();
								name = (String) _datacursor.getValue();
								compareList.add(name);
							}
						}
					}
					if (oldDocList!=null) {
						for (int i = 0; i < oldDocList.length; i++) {
							IData tempOldDoc = oldDocList[i];
							IDataCursor _datacursor1 = tempOldDoc.getCursor();
							String key;
							String name;
		
							while (_datacursor1.hasMoreData()) {
								_datacursor1.next();
								key = _datacursor1.getKey();
								name = (String) _datacursor1.getValue();
								oldList.add(name);
							}
						}
					}
					
				}
				else{
				
				//check if new country is added in old list
				for(int i =0;i<newDocList.length;i++){
					isPresent = false;
					IData tempNewDoc= newDocList[i];
					IDataCursor _datacursor = tempNewDoc.getCursor() ;
					String key;
					String name;
					
					while(_datacursor.hasMoreData()){
						_datacursor.next();
						key = _datacursor.getKey();
						name = (String)_datacursor.getValue();
						
						//if (oldDocList!=null) {
							String oldValue="";
							oldList = new ArrayList<String>();
							for (int j = 0; j < oldDocList.length; j++) {
								IData tempOld = oldDocList[j];
								IDataCursor _datacursorOld = tempOld.getCursor();
								oldValue = (String) IDataUtil.get(
										_datacursorOld, key);
								oldList.add(oldValue);
								if (name.equalsIgnoreCase(oldValue)) {
									isPresent = true;
								}
							}
							
						//}
						if(!isPresent){
							compareList.add(name);
						}
					}
					
				}
					}
			Iterator<String> it =  compareList.iterator();
			String isDocistChangedForNew = "";
			  while(it.hasNext()){
				  String temp  = it.next();
				  isDocistChangedForNew = isDocistChangedForNew +temp+", " ;
			  }
			  if(isDocistChangedForNew.length()==0){
				  isDocistChangedForNew = "(BLANK)";
			  }
			 String isDocistChangedForOld = "";
				isDocistChanged = isDocistChangedForNew + " from ";
				Iterator<String> it1 = oldList.iterator();
				while (it1.hasNext()) {
					String temp = it1.next();
					isDocistChangedForOld = isDocistChangedForOld + temp + ", ";
				}
			
				 if(isDocistChangedForOld.length()==0){
					 isDocistChangedForOld = "(BLANK)";
				  }
				 isDocistChanged = isDocistChanged + isDocistChangedForOld;
			/*oldList = new ArrayList<String>();
			for(int i =0;i<oldDocList.length;i++){
			isPresent = false;
			IData tempOldDoc= oldDocList[i];
			IDataCursor _datacursor = tempOldDoc.getCursor() ;
			String key;
			String name;
			
			while(_datacursor.hasMoreData()){
				_datacursor.next();
				key = _datacursor.getKey();
				name = (String)_datacursor.getValue();
				oldList.add(name);
				//if (oldDocList!=null) {
					String newValue="";
					compareList = new ArrayList<String>();
					for (int j = 0; j < newDocList.length; j++) {
						IData tempNew = newDocList[j];
						IDataCursor _datacursorOld = tempNew.getCursor();
						newValue = (String) IDataUtil.get(
								_datacursorOld, key);
						compareList.add(newValue);
						if (name.equalsIgnoreCase(newValue)) {
							isPresent = true;
						}
					}
					
				//}
				
			}*/
			//}
			
			
			
			
		
			
			
		//}
		/*String isDocistChanged = "";
		if(!isPresent){
			Iterator<String> it =  compareList.iterator();
			  while(it.hasNext()){
				  String temp  = it.next();
				  isDocistChanged = isDocistChanged +temp+"," ;
			  }
			  isDocistChanged = isDocistChanged + " from " ;
			  Iterator<String> it1 =  oldList.iterator();
			  while(it1.hasNext()){
				  String temp  = it1.next();
				  isDocistChanged = isDocistChanged +temp+"," ;
			  }
		}*/
		
		/*String list2[] = new String[compareList.size()];
		String isDocistChanged = "";
		   if (compareList.size()>0) {
			
			list2 = compareList.toArray(list2);
			isCountryListChanged = "true";
			  Iterator<String> it =  compareList.iterator();
			  while(it.hasNext()){
				  String temp  = it.next();
				  isDocistChanged = isDocistChanged +temp+"," ;
			  }
		}
			*/	 
		IDataCursor pipelineCursor_1 = pipeline.getCursor();  
		 
		IDataUtil.put( pipelineCursor_1, "compare", isDocistChanged);  
		pipelineCursor_1.destroy();  
		// --- <<IS-END>> ---

                
	}



	public static final void compareValuesForAudit (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(compareValuesForAudit)>> ---
		// @sigtype java 3.5
		// [i] field:0:required oldvalue
		// [i] field:0:required newvalue
		// [i] field:0:required fieldName
		// [i] field:0:required userId
		// [o] field:0:required compareResult
		IDataCursor pipelineCursor = pipeline.getCursor(); 
		String oldvalue= IDataUtil.getString( pipelineCursor, "oldvalue" ); 
		String newvalue = IDataUtil.getString( pipelineCursor, "newvalue" ); 
		String fieldName = IDataUtil.getString( pipelineCursor, "fieldName" ); 
		String userId = IDataUtil.getString( pipelineCursor, "userId" ); 
		String compareValue = "false";
		pipelineCursor.destroy();  
		 if ((oldvalue == null || oldvalue.equalsIgnoreCase("")) && (newvalue == null || newvalue.equalsIgnoreCase(""))) {
		      
			 compareValue ="false";
		        
		    }
		 else{
			 if (oldvalue == null) {
		            if (newvalue != null) {
		            	compareValue ="true";
		            }
		            
		        }  
			 else{ 
				 if(oldvalue!=null){
					 if (newvalue == null) {
			            	compareValue ="true";
			            }else{
			            	if(!oldvalue.equalsIgnoreCase(newvalue)){
			            		compareValue ="true";
			            	}
			            }
			 		}
				
				 
			 }
		    }
		 if("true".equalsIgnoreCase(compareValue)){
			 //c)	Modified the User Role of <JJAR User>*, <New User Role> Role from <Old User Role> Role
			 compareValue = "Modified the " +fieldName + " of "+ userId +", " +newvalue +" from "+oldvalue;
		 }
		 
		 IDataCursor pipelineCursor_1 = pipeline.getCursor();  
			IDataUtil.put( pipelineCursor_1, "compareResult", compareValue);  
			pipelineCursor_1.destroy();  
				
		// --- <<IS-END>> ---

                
	}



	public static final void contains (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(contains)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required parentString
		// [i] field:0:required searchString
		// [o] field:0:required result
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	parentString = IDataUtil.getString( pipelineCursor, "parentString" );
			String	searchString = IDataUtil.getString( pipelineCursor, "searchString" );
			String result = "false";
		pipelineCursor.destroy();
		
			if(parentString!=null && searchString!=null)
				{
					if (parentString.indexOf(searchString) >=0 ){
						result = "true";
					}
					else{	
						result = "false";
					}
				}
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "result", result );
		pipelineCursor_1.destroy();
			
		// --- <<IS-END>> ---

                
	}



	public static final void createKeyValuePair (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(createKeyValuePair)>> ---
		// @sigtype java 3.5
		// [i] record:0:required document
		// [o] record:1:required outputDocList
		// [o] - field:0:required key
		// [o] - field:0:required value
		IDataCursor pipelineCursor = pipeline.getCursor(); 
		IData	document = IDataUtil.getIData( pipelineCursor, "document" );
		
		
		IDataCursor _datacursor = document.getCursor() ;
		//_datacursor.first();
		String key="";
		String name="";
		;
		int i=0;
		IData[] outputDocList = new IData[500];
		//HashMap<String, String> tempMap = new HashMap<String, String>();
		while(_datacursor.hasMoreData()){
		_datacursor.next();
		key = _datacursor.getKey();
		
		if(_datacursor.getValue() instanceof IData[]){
			//IData[] doclist =(IData[]) _datacursor.getValue();
			
		}else{
			name = (String)_datacursor.getValue();
		}
		//tempMap.put(key, name);
		outputDocList[i]= IDataFactory.create();
		IDataCursor outputDocListCursor = outputDocList[i].getCursor();
		IDataUtil.put( outputDocListCursor, "key", key);
		IDataUtil.put( outputDocListCursor, "value", name );
		i++;
		}
		
		
		
		IDataCursor pipelineCursor_1 = pipeline.getCursor();  
		 
		IDataUtil.put( pipelineCursor_1, "outputDocList", outputDocList );
		
		pipelineCursor_1.destroy();  
		// --- <<IS-END>> ---

                
	}



	public static final void escapeSpclChar (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(escapeSpclChar)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inputString
		// [o] field:0:required replacedString
		IDataCursor pipelineCursor = pipeline.getCursor(); 
		String search = IDataUtil.getString( pipelineCursor, "inputString" );
		if(search!=null && search!=""){
			if (search.contains("'") ){
			
			    search = search.replaceAll("'", "''");
			  
			}
			if (search.contains("&") ){
				
			    search = search.replaceAll("&", "&amp;");
			  
			}
			if (search.contains("<") ){
				
			    search = search.replaceAll("<", "&lt;");
			  
			}
			if (search.contains(">") ){
				
			    search = search.replaceAll(">", "&gt;");
			}
			if (search.contains("%") ){
					
				search = search.replaceAll("%", ";%");
			     
			}
		}
		
		IDataCursor pipelineCursor_1 = pipeline.getCursor();  
		 
		IDataUtil.put( pipelineCursor_1, "replacedString", search);  
		pipelineCursor_1.destroy(); 
		// --- <<IS-END>> ---

                
	}



	public static final void filterDocListByName (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(filterDocListByName)>> ---
		// @sigtype java 3.5
		// [i] record:0:required inputDoc
		// [i] field:0:required key
		// [o] record:1:required docList
		IDataCursor pipelineCursor = pipeline.getCursor(); 
		IData	document = IDataUtil.getIData( pipelineCursor, "inputDoc" );
		String  key = IDataUtil.getString( pipelineCursor, "key" );  
		IData[] docList = null;
		IDataCursor _datacursor = document.getCursor() ;
		docList = IDataUtil.getIDataArray(_datacursor,key);
		/*while(_datacursor.hasMoreData()){
			_datacursor.next();
			docList = IDataUtil.getIDataArray(_datacursor,key);
		}*/
		
		
		IDataCursor pipelineCursor_1 = pipeline.getCursor();  
		 
		IDataUtil.put( pipelineCursor_1, "docList", docList);  
		pipelineCursor_1.destroy(); 
		// --- <<IS-END>> ---

                
	}


    public static final Values multiConcat (Values in)
    {
        Values out = in;
		// --- <<IS-START(multiConcat)>> ---
		// @sigtype java 3.0
		// [i] field:0:required inStr1
		// [i] field:0:required inStr2
		// [i] field:0:required inStr3
		// [i] field:0:required inStr4
		// [i] field:0:required inStr5
		// [i] field:0:required inStr6
		// [i] field:0:required inStr7
		// [i] field:0:required inStr8
		// [i] field:0:required inStr9
		// [i] field:0:required inStr10
		// [o] field:0:required outStr
		/**
		 * Service takes in up to ten strings, checks them for null (see Shared tab
		 * method checkNull), and concatenates all of them together. checkNull
		 * returns a "" if the String is null, effectively cancelling out its effect
		 * on the concatenation. Returns the concatenated String as "outStr".
		 * 
		 */ 
		
		String str1 = checkNull(in.getString("inStr1"));
		String str2 = checkNull(in.getString("inStr2"));
		String str3 = checkNull(in.getString("inStr3"));
		String str4 = checkNull(in.getString("inStr4"));
		String str5 = checkNull(in.getString("inStr5"));
		String str6 = checkNull(in.getString("inStr6"));
		String str7 = checkNull(in.getString("inStr7"));
		String str8 = checkNull(in.getString("inStr8"));
		String str9 = checkNull(in.getString("inStr9"));
		String str10 = checkNull(in.getString("inStr10"));
		
		String outStr = str1 + str2 + str3 + str4 + str5 + str6 + str7 + str8 + str9 + str10;
		
		out.put("outStr", outStr);
		
		// --- <<IS-END>> ---
        return out;
                
	}



	public static final void removeLastOccuranceOfCharFromString (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(removeLastOccuranceOfCharFromString)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inString
		// [i] field:0:required removeString
		// [o] field:0:required outString
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	inString = IDataUtil.getString( pipelineCursor, "inString" );
		String	removeString = IDataUtil.getString( pipelineCursor, "removeString" );
		pipelineCursor.destroy();
		
		String outString="";
		int Index=-1;
		
		if(inString != null || inString.trim()!=""){
		
		Index=inString.lastIndexOf(removeString);
		if(Index==-1){
		}else{
			outString=inString.substring(0,Index);
		}
		}
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "outString", outString );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void splitDate (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(splitDate)>> ---
		// @sigtype java 3.5
		// [i] field:0:required date
		// [i] field:0:required pattern
		// [o] field:0:required yearOut
		// [o] field:0:required dayOut
		// [o] field:0:required monthOut
		try {
			
			IDataCursor pipelineCursor = pipeline.getCursor();
			String	date = IDataUtil.getString( pipelineCursor, "date" );
			String	pattern = IDataUtil.getString( pipelineCursor, "pattern" );
			if("yyyy-MM-dd".equalsIgnoreCase(pattern)){
				String[] dateArray = date.split("-");
				String year = dateArray[0];
				String month = dateArray[1];
				String day = dateArray[2];
				IDataCursor pipelineCursor_1 = pipeline.getCursor();
				IDataUtil.put( pipelineCursor_1, "yearOut", year);
				IDataUtil.put( pipelineCursor_1, "monthOut", month);
				IDataUtil.put( pipelineCursor_1, "dayOut", day);
			}
			
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		// --- <<IS-END>> ---

                
	}



	public static final void splitStringByADelimiter (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(splitStringByADelimiter)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required inputStringToSplit
		// [i] field:0:required inputDelimiter
		// [o] field:1:required outputStringList
		IDataCursor pipelineCursor = pipeline.getCursor(); 
		String StringToSplit= IDataUtil.getString( pipelineCursor, "inputStringToSplit" );  
		String Delimiter= IDataUtil.getString( pipelineCursor, "inputDelimiter" );  
		
		Delimiter = '\\'+Delimiter;
		
		String[] StringList = null;
		
		Integer value = null;
		
		if(StringToSplit!=null)
		StringList = StringToSplit.split(Delimiter);
		 
		pipelineCursor.insertAfter("outputStringList", StringList);
			
		pipelineCursor.destroy();
			
		// --- <<IS-END>> ---

                
	}



	public static final void substituteVariables (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(substituteVariables)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inputString
		// [o] field:0:required outputString
		IDataCursor cursor = pipeline.getCursor();
		
		String strInputString = null;
		if (cursor.first("inputString"))
		{
		  strInputString = (String) cursor.getValue();
		}
		else
		{
		  return; // Input string is null
		}
		
		// pipeline
		String variableNotFoundString = IDataUtil.getString(cursor, "variableNotFoundString");
		
		String strOutputString = "";
		 
		int intCurrentIndex = 0;
		int intStartIndex = 0;
		int intEndIndex = 0;
		while ((intStartIndex = strInputString.indexOf('%', intCurrentIndex)) != -1)
		{
		  // If \%, then ignore...don't perform variable substitution
		  if ((intStartIndex != 0) && (strInputString.charAt(intStartIndex - 1) == '\\'))
		  {
		    strOutputString = strOutputString + strInputString.substring(intCurrentIndex, intStartIndex - 1) + '%';
		    intCurrentIndex = intStartIndex + 1;
		    continue;
		  }
		
		  // Find the ending %
		  intEndIndex = strInputString.indexOf('%', intStartIndex + 1);
		  if (intEndIndex == -1)
		  {
		    break;
		  }
		
		  // Print out everything before the %
		  strOutputString = strOutputString + strInputString.substring(intCurrentIndex, intStartIndex);
		  // Find the string to substitute
		  String strStringToSubstitute = null;
		  String strVariableName = strInputString.substring(intStartIndex + 1, intEndIndex);
		
		  if (strVariableName.equals(""))
		  {
		    // We had occurence of "%%"
		    intCurrentIndex = intEndIndex + 1;
		    continue;
		  }
		
		  // Perform variable substitution
		  StringTokenizer tokenizedString = new StringTokenizer(strVariableName, "/", false);
		  int maxTokens = tokenizedString.countTokens();
		  IData currentRecord = null;
		  int intTokenIndex = 1;
		  while (tokenizedString.hasMoreTokens())
		  {
		    String strCurrentToken = tokenizedString.nextToken();
		    System.out.println("strCurrentToken = " + strCurrentToken);
		
		    IDataCursor idc = null;
		    if (currentRecord == null)
		    {
		      // New search - look in pipeline for record/string
		      idc = cursor;
		    }
		    else
		    {
		      idc = currentRecord.getCursor();
		    }
		
		    if (idc.first(strCurrentToken))
		    {
		      Object o = idc.getValue();
		      if ((intTokenIndex == maxTokens) && (o instanceof String))
		      {
		        // This is the last token. Look for a string
		        // Variable found in pipeline
		        strStringToSubstitute = (String) o;
		        strOutputString = strOutputString + strStringToSubstitute;
		        intCurrentIndex = intEndIndex + 1;
		      }
		      else if ((intTokenIndex != maxTokens) && (o instanceof IData))
		      {
		        // Look for a IData (record)
		        currentRecord = (IData) o;
		      }
		      else
		      {
		        // Type mismatch - variable not found in pipeline
		        // strOutputString = strOutputString +
		        // strInputString.substring(intStartIndex, intEndIndex + 1);
		        intCurrentIndex = intEndIndex + 1;
		        break; // Ignore other tokens
		      }
		    }
		    else
		    {
		      // Variable not found in pipeline
		      // strOutputString = strOutputString +
		      // strInputString.substring(intStartIndex, intEndIndex + 1);
		      strOutputString = strOutputString + variableNotFoundString;
		      intCurrentIndex = intEndIndex + 1;
		      break; // Ignore other tokens
		    }
		
		    intTokenIndex++;
		  }
		
		}
		
		strOutputString = strOutputString + strInputString.substring(intCurrentIndex);
		
		cursor.insertAfter("outputString", strOutputString);
		cursor.destroy();
			
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	static int staticSeq = -1;
	
	static String nodeID = null;
	static HashMap groupList;
	static int nextCounter= 0 ;
	
	private static String checkNull(String inputString)
	{
	  if (inputString == null)
	    return "";
	  else
	    return inputString;
	}
	
	
		
	// --- <<IS-END-SHARED>> ---
}

