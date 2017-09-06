package PU456_JJAR_Users_v1;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2017-08-23 02:34:32 EDT
// -----( ON-HOST: itsusralsp03487.jnj.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import com.webmethods.caf.faces.data.dir.UserModel;
import com.webmethods.sc.directory.DirectorySystemFactory;
import com.webmethods.sc.directory.IDirectoryGroup;
import com.webmethods.sc.directory.IDirectoryPrincipal;
import com.webmethods.sc.directory.IDirectorySession;
import com.webmethods.sc.directory.IDirectoryRole;
import com.webmethods.sc.directory.IDirectorySystem;
import com.webmethods.sc.directory.IDirectoryService;
// --- <<IS-END-IMPORTS>> ---

public final class Utils

{
	// ---( internal utility methods )---

	final static Utils _instance = new Utils();

	static Utils _newInstance() { return new Utils(); }

	static Utils _cast(Object o) { return (Utils)o; }

	// ---( server methods )---




	public static final void addUserToMWSRole (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(addUserToMWSRole)>> ---
		// @sigtype java 3.5
		// [i] field:0:required userId
		// [i] field:0:required roleName
		IDirectorySession session = createIDirectorySession();
		IDataCursor pipelineCursor = pipeline.getCursor();  
		String  user = IDataUtil.getString( pipelineCursor, "userId" );  
		String  role = IDataUtil.getString( pipelineCursor, "roleName" );  
		pipelineCursor.destroy();  
		IDirectoryPrincipal principalUser = session.lookupPrincipalByName(user, IDirectoryPrincipal.TYPE_USER);  
		if(principalUser != null){
			IDirectoryRole principalRole = (IDirectoryRole) session.lookupPrincipalByName(role, IDirectoryPrincipal.TYPE_ROLE);
			session.addPrincipalToRole(principalUser.getID(), principalRole.getID());
			
		}
			
		// --- <<IS-END>> ---

                
	}



	public static final void compareCountryList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(compareCountryList)>> ---
		// @sigtype java 3.5
		// [i] recref:1:required userOldList PU456_JJAR_Users_v1.Documents:userDocumentforAudit
		// [i] record:1:optional countryList
		// [i] - field:0:optional id
		// [i] - field:0:optional name
		// [i] - field:0:optional tasks
		// [i] - field:0:optional notification
		// [i] field:0:required userId
		// [o] field:0:required compare
		IDataCursor pipelineCursor = pipeline.getCursor(); 
		IData[] countryListOld = IDataUtil.getIDataArray( pipelineCursor, "userOldList" ); 
		
		IData[] countryListnew = IDataUtil.getIDataArray( pipelineCursor, "countryList" ); 
		String  userId = IDataUtil.getString( pipelineCursor, "userId" );  
		ArrayList<String> compareList = new ArrayList<String>();
		if(countryListnew!=null){
			//check if new country is added in old list
			for(int i =0;i<countryListnew.length;i++){
				
				IData tempCountry = countryListnew[i];
				IDataCursor _datacursor = tempCountry.getCursor() ;
				
				String countryidNewName = (String) IDataUtil.get(_datacursor,"name");
				boolean isPresent = false;
				if (countryListOld!=null) {
					for (int j = 0; j < countryListOld.length; j++) {
						IData tempCountryOld = countryListOld[j];
						IDataCursor _datacursorOld = tempCountryOld.getCursor();
						String countryidOld = (String) IDataUtil.get(
								_datacursorOld, "country");
						if (countryidNewName.equalsIgnoreCase(countryidOld)) {
							isPresent = true;
						}
					}
				}
				if(!isPresent){
					compareList.add("Safety Reviewer "+userId+ " assigned " + countryidNewName);
				}
			}
		}
		if(countryListOld!=null && countryListOld.length>0){
			//check if old country is removed in new list
			for(int k =0;k<countryListOld.length;k++){
				
				IData tempCountry = countryListOld[k];
				IDataCursor _datacursor = tempCountry.getCursor() ;
			
				String countryidOldName = (String) IDataUtil.get(_datacursor,"country");
				boolean isPresent = false;
				if (countryidOldName!=null && countryidOldName!="") {
					if (countryListnew != null) {
						for (int j = 0; j < countryListnew.length; j++) {
							IData tempCountryNew = countryListnew[j];
							IDataCursor _datacursorNew = tempCountryNew
									.getCursor();
							String countryNew = (String) IDataUtil.get(
									_datacursorNew, "name");
							if (countryidOldName.equalsIgnoreCase(countryNew)) {
								isPresent = true;
							}
						}
					}
					if(!isPresent){
						compareList.add("Safety Reviewer "+userId+ " removed from " + countryidOldName);
					}
				}
				
			}
		}
		
		String list2[] = new String[compareList.size()];
		String isCountryListChanged = "";
		   if (compareList.size()>0) {
			
			/*list2 = compareList.toArray(list2);
			isCountryListChanged = "true";*/
			  Iterator<String> it =  compareList.iterator();
			  while(it.hasNext()){
				  String temp  = it.next();
				  isCountryListChanged = isCountryListChanged +temp+" " ;
			  }
		}
				 
		IDataCursor pipelineCursor_1 = pipeline.getCursor();  
		 
		IDataUtil.put( pipelineCursor_1, "compare", isCountryListChanged);  
		pipelineCursor_1.destroy();  
			
		// --- <<IS-END>> ---

                
	}



	public static final void containsInDocument (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(containsInDocument)>> ---
		// @sigtype java 3.5
		// [i] field:0:required countryCode
		// [i] record:1:optional countryList
		// [i] - field:0:optional id
		// [i] - field:0:optional name
		// [i] - field:0:optional tasks
		// [i] - field:0:optional notification
		// [i] field:0:required type
		// [i] field:0:required permissionValue
		// [i] field:0:required userid
		// [o] field:0:required compareResult
		IDataCursor pipelineCursor = pipeline.getCursor(); 
		IData[] countryList = IDataUtil.getIDataArray( pipelineCursor, "countryList" ); 
		String  countryCodeOld = IDataUtil.getString( pipelineCursor, "countryCode" );  
		String  permissionType = IDataUtil.getString( pipelineCursor, "type" ); 
		String  permissionvalue = IDataUtil.getString( pipelineCursor, "permissionValue" ); 
		String  userid = IDataUtil.getString( pipelineCursor, "userid" );
		pipelineCursor.destroy();  
		int count = 0;
		String  compareString = "";
		if(countryList.length>0){
			for(int i =0;i<countryList.length;i++){
				
				IData tempCountry = countryList[i];
				IDataCursor _datacursor = tempCountry.getCursor() ;
				String countryId = (String) IDataUtil.get(_datacursor,"name") ;
				if(countryCodeOld.equals(countryId)){
					
					String tasksNew = (String) IDataUtil.get(_datacursor,"tasks") ;
					String notifyNew = (String) IDataUtil.get(_datacursor,"notification") ;
					if ("tasks".equalsIgnoreCase(permissionType)) {
						if (!tasksNew.equals(permissionvalue)) {
							if ("Y".equalsIgnoreCase(tasksNew)) {
								compareString = "Safety Reviewer"+userid+ " assigned " + countryId
										+ " Tasked permission";
							} else {
								compareString = "Safety Reviewer"+ userid + " removed " + countryId
										+ "Tasked permission";
							}
						}
					}
					if ("notification".equalsIgnoreCase(permissionType)) {
						if (!notifyNew.equals(permissionvalue)) {
							if ("Y".equalsIgnoreCase(notifyNew)) {
								compareString = "Safety Reviewer"+ userid +" assigned " + countryId
										+ " Notified Permission";
							} else {
								compareString = "Safety Reviewer"+ userid +" removed " + countryId
										+ " Notified Permission";
							}
						}
					}
					break;
				}
				count++;
			}
			/*if(countryList.length==count){
				compareString = countryCodeOld + " is deleted";
			}*/
		}
		 IDataCursor pipelineCursor_1 = pipeline.getCursor();  
			IDataUtil.put( pipelineCursor_1, "compareResult", compareString);  
			pipelineCursor_1.destroy();  
			
		// --- <<IS-END>> ---

                
	}



	public static final void createHeaderList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(createHeaderList)>> ---
		// @sigtype java 3.5
		// [i] record:0:required DocList
		// [o] field:1:required HeaderList
		IDataCursor pipelineCursor = pipeline.getCursor(); 
		IData	document = IDataUtil.getIData( pipelineCursor, "DocList" );
		
		
		IDataCursor _datacursor = document.getCursor() ;
		
		String key="";
		
		int i=0;
		//String[] outputDocList = new String[500];
		ArrayList<String> tempList = new ArrayList<String>();
		
		while(_datacursor.hasMoreData()){
		_datacursor.next();
		key = _datacursor.getKey();
		tempList.add(key);
		//outputDocList[i] = key;
		//i++;
		}
		
		String[] outputDocList = tempList.toArray(new String[tempList.size()]);
		
		IDataCursor pipelineCursor_1 = pipeline.getCursor();  
		 
		IDataUtil.put( pipelineCursor_1, "HeaderList", outputDocList );
		
		pipelineCursor_1.destroy();  
		// --- <<IS-END>> ---

                
	}



	public static final void deleteUserFromMWSRole (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(deleteUserFromMWSRole)>> ---
		// @sigtype java 3.5
		// [i] field:0:required userId
		// [i] field:0:required existingRole
		//IDirectorySession session = createIDirectorySession();
		IDirectorySystem system = DirectorySystemFactory.getDirectorySystem(); 
		IDirectorySession session = system.createSession();  
		IDataCursor pipelineCursor = pipeline.getCursor();  
		String  user = IDataUtil.getString( pipelineCursor, "userId" );  
		String  existingRole = IDataUtil.getString( pipelineCursor, "existingRole" );  
		 
		pipelineCursor.destroy();  
		IDirectoryPrincipal principalUser = session.lookupPrincipalByName(user, IDirectoryPrincipal.TYPE_USER);  
		if(principalUser != null){
			if(existingRole!=null){
			IDirectoryRole principalExistingRole = (IDirectoryRole) session.lookupPrincipalByName(existingRole, IDirectoryPrincipal.TYPE_ROLE);
			session.removePrincipalFromRole(principalUser.getID(), principalExistingRole.getID());
			}
		}
			
		// --- <<IS-END>> ---

                
	}



	public static final void fetchUserMWSRoles (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(fetchUserMWSRoles)>> ---
		// @sigtype java 3.5
		// [i] field:0:required userId
		// [o] field:1:required roleList
		IDirectorySession session = createIDirectorySession();
		IDataCursor pipelineCursor = pipeline.getCursor();  
		String  user = IDataUtil.getString( pipelineCursor, "userId" );  
		String[] roleList = null;
		pipelineCursor.destroy();  
		IDirectoryPrincipal principalUser = session.lookupPrincipalByName(user, IDirectoryPrincipal.TYPE_USER);  
		if(principalUser != null){
			List<IDirectoryRole> roles = session.getRoleMembership(principalUser.getID());
			roleList = new String[roles.size()];
			Iterator<IDirectoryRole> iter = roles.iterator();
			int i=0;
			while(iter.hasNext()){
				roleList[i] = iter.next().getName();
				i++;
			}
		}
		
		IDataCursor pipelineCursor_1 = pipeline.getCursor();  
		 
		IDataUtil.put( pipelineCursor_1, "roleList", roleList );
		
		pipelineCursor_1.destroy();  
		// --- <<IS-END>> ---

                
	}



	public static final void modifyUserRoleInMWS (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(modifyUserRoleInMWS)>> ---
		// @sigtype java 3.5
		// [i] field:0:required userId
		// [i] field:0:required existingRole
		// [i] field:0:required newRole
		IDirectorySession session = createIDirectorySession();
		IDataCursor pipelineCursor = pipeline.getCursor();  
		String  user = IDataUtil.getString( pipelineCursor, "userId" );  
		String  existingRole = IDataUtil.getString( pipelineCursor, "existingRole" );  
		String  newRole = IDataUtil.getString( pipelineCursor, "newRole" );  
		pipelineCursor.destroy();  
		IDirectoryPrincipal principalUser = session.lookupPrincipalByName(user, IDirectoryPrincipal.TYPE_USER);  
		if(principalUser != null){
			if(existingRole!=null){
			IDirectoryRole principalExistingRole = (IDirectoryRole) session.lookupPrincipalByName(existingRole, IDirectoryPrincipal.TYPE_ROLE);
			session.removePrincipalFromRole(principalUser.getID(), principalExistingRole.getID());
			}
			
			if(newRole!=null){
			IDirectoryRole principalNewRole = (IDirectoryRole) session.lookupPrincipalByName(newRole, IDirectoryPrincipal.TYPE_ROLE);
			session.addPrincipalToRole(principalUser.getID(), principalNewRole.getID());
			}
		}
		// --- <<IS-END>> ---

                
	}



	public static final void searchUserFromJJEDS (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(searchUserFromJJEDS)>> ---
		// @sigtype java 3.5
		// [i] field:0:optional WWID
		// [o] field:0:required uid
		// [o] field:0:required sn
		// [o] field:0:required givenname
		// [o] field:0:required mail
		// [o] field:0:required telephoneNumber
		// [o] field:0:required jnjMSUsername
		// [o] field:0:required jnjMSDomain
		// [o] field:0:required status
		// [o] field:0:required ntId
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			//String	userId = IDataUtil.getString( pipelineCursor, "userId" );
			String	WWID = IDataUtil.getString( pipelineCursor, "WWID" );
			String LDAP_PROVIDER_URL = "ldap://jjedsdir.na.jnj.com/o=jnj,dc=jjedsed,dc=jnj,dc=com";
			String LDAP_CONTEXT_FACTORY = "com.sun.jndi.ldap.LdapCtxFactory";
			String WWID_FILTER = "(&(jnjBusinessUnit=*) (employeeType=*) (uid=";
			Hashtable env = new Hashtable();
			
				/*if (WWID != null) {
					return null;
				}*/
				javax.naming.ldap.LdapContext context = null;
				String uid = null;
				String sn = null;
				String givenname = null;
				String mail = null;
				String status =null;
				String ntId = null;
				
				try {
				    env.put(Context.INITIAL_CONTEXT_FACTORY, LDAP_CONTEXT_FACTORY);
				    env.put(Context.PROVIDER_URL, LDAP_PROVIDER_URL);
				    context = new InitialLdapContext(env, null);
				} catch (NamingException ne) {
					/*LOGGER.fatal("Error Connecting to JJEDS LDAP Server ", ne);
					return null;*/
				}
				try {
					StringBuffer sbQuery = new StringBuffer();
					sbQuery.append(WWID_FILTER).append(WWID).append("))");
					
					javax.naming.directory.SearchControls controls = new SearchControls();
					controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
					javax.naming.NamingEnumeration enumPeople = context.search("", sbQuery.toString(), controls);
		    		while (enumPeople.hasMoreElements()) {
						javax.naming.directory.SearchResult searchResult = (SearchResult)enumPeople.nextElement();
						Attributes attributes = searchResult.getAttributes();
						
						
				
						if (attributes != null) {
							
							uid = (String)attributes.get(ATTR_WWID).get();
							sn = (String)attributes.get(ATTR_LAST_NAME).get();
							givenname = (String)attributes.get(ATTR_FIRST_NAME).get();
							if(attributes.get(ATTR_EMAIL)!=null ) {
								mail = (String)attributes.get(ATTR_EMAIL).get();
							}else if (attributes.get(ATTR_PARTNER_EMAIL)!=null ) {
								mail = (String)attributes.get(ATTR_PARTNER_EMAIL).get();
							}
							
							
							status = (String)attributes.get(ATTR_STATUS).get();
							ntId = (String)attributes.get(ATTR_NTID).get();
							
						}
						// We are only interested in the first result always
						break;
					}
				} catch (NamingException ne) {
					//LOGGER.fatal("Error trying to retrieve user details from JJEDS for Id " + wwid, ne);
				}
				
			
				IDataCursor pipelineCursor_1 = pipeline.getCursor();  
				 
				IDataUtil.put( pipelineCursor_1, "uid", uid );
				IDataUtil.put( pipelineCursor_1, "sn", sn );
				IDataUtil.put( pipelineCursor_1, "givenname", givenname);
				IDataUtil.put( pipelineCursor_1, "mail", mail);
				IDataUtil.put( pipelineCursor_1, "status", status );
				IDataUtil.put( pipelineCursor_1, "ntId", ntId );
				
				
				
				
			pipelineCursor.destroy();
			pipelineCursor_1.destroy();
			
		// pipeline
			
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	
	public static final String ATTR_WWID = "uid";
	public static final String ATTR_NTID = "jnjMSUserName";
	public static final String ATTR_DISPLAY_NAME = "jnjDisplayName";
	public static final String ATTR_FIRST_NAME = "givenName";
	public static final String ATTR_LAST_NAME = "sn";
	public static final String ATTR_EMAIL = "mail";
	public static final String ATTR_PARTNER_EMAIL = "jnjPartnerEmailAddress";
	public static final String ATTR_DN = "distinguishedName";
	public static final String ATTR_STATUS = "employeeType";
	public static final String ATTR_MANAGER = "manager";
	public static final String ATTR_DOMAIN = "jnjMSDomain";
	public static final boolean IS_TEST = false;
	
	
	private static IDirectorySession createIDirectorySession(){
		IDirectorySystem system = DirectorySystemFactory.getDirectorySystem();  
		System.out.println("System value is: "+system);  
		IDirectorySession session = system.createSession();  
		System.out.println("Session value is: "+session);  
		return session;
	}
	
	
	
	
		
	// --- <<IS-END-SHARED>> ---
}

