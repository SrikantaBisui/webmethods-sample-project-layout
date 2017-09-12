package PU456_JJAR_Common;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2017-04-26 09:55:52 EDT
// -----( ON-HOST: itsusralsp03487.jnj.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.*;
import com.wm.util.coder.*;
import com.wm.util.Debug;
import java.net.UnknownHostException;
import com.wm.app.b2b.server.*;
import java.util.Date;
import java.net.InetAddress;
import com.wm.lang.ns.NSName;
import java.text.*;
import java.util.*;
// --- <<IS-END-IMPORTS>> ---

public final class Services

{
	// ---( internal utility methods )---

	final static Services _instance = new Services();

	static Services _newInstance() { return new Services(); }

	static Services _cast(Object o) { return (Services)o; }

	// ---( server methods )---




	public static final void readFile (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(readFile)>> ---
		// @sigtype java 3.5
		IDataCursor pc = pipeline.getCursor();
		String path = IDataUtil.getString(pc, "path");
		String mode = IDataUtil.getString(pc, "mode");
		String start = IDataUtil.getString(pc, "start");
		String length = IDataUtil.getString(pc, "length");
		
		int strt = start != null ? new Integer(start).intValue() : 0;
		int len = length != null ? new Integer(length).intValue() : -1;
		
		boolean exists = false;
		try {
			exists = exists(path);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
		if (path != null && exists) {
			try {
				if (mode.equals("string")) {
					String read = readString(path, strt, len);
					IDataUtil.put(pc, "string", read);
					IDataUtil.put(pc, "length", String.valueOf(read.length()));
				} else if (mode.equals("stringlist")) {	
					String[] read = readLines(path, strt, len);
					IDataUtil.put(pc, "stringlist", read);
					IDataUtil.put(pc, "length", String.valueOf(read.length));
				} else if (mode.equals("bytes")) {
					byte[] read = readBytes(path, strt, len);
					IDataUtil.put(pc, "bytes", read);
					IDataUtil.put(pc, "length", String.valueOf(read.length));
				} else {
					InputStream read = readStream(path);
					IDataUtil.put(pc, "stream", read);
					IDataUtil.put(pc, "length", String.valueOf(read.available()));
				}
			} catch (Exception e) {
				throw new ServiceException(e);
			}
		}
		pc.destroy();
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	public static boolean exists(String path)
			throws Exception {
			boolean exists = false;
			File file = new File(path);
			return file.exists() && (file.isFile() || file.isDirectory());
		}
	
	public static String readString(String path, int start, int length)
			throws Exception {
			return new String(readBytes(path, start, length));
		}
		
		public static String[] readLines(String path, int start, int length)
			throws Exception {
			if (!exists(path)) {
				return new String[0];
			}
		
			ArrayList content = new ArrayList();
			BufferedReader in = new BufferedReader(new FileReader(path));
			String line = "";
			long ln = 0;
			while ((line = in.readLine()) != null) {
				if (ln >= start) {
					content.add(line);
					if (length > 0 && start + ln >= length) {
						break;
					}
				}
				ln++;
			}
			in.close();
			return (String[])content.toArray(new String[0]);
		}
		
		public static byte[] readBytes(String path, int start, int length)
			throws Exception {
			if (!exists(path)) {
				return new byte[0];
			}
		
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			FileInputStream fin = (FileInputStream)readStream(path);
			int pos = start;
			int read = 0;
			byte[] buffer = new byte[8192];
			while ((read = fin.read(buffer, 0, buffer.length)) > 0 && (pos < length || length == -1)) {
				bout.write(buffer, 0, read);
				pos += read;
			}
			bout.flush();
		
			byte[] bytes = bout.toByteArray();
			bout.close();
			return bytes;
		}
		
		public static InputStream readStream(String path)
			throws Exception {
			return new FileInputStream(path);
		}
		
		public static long size(String filename)
			throws Exception {
			return new File(filename).length();
		}
		
		public static String getName(String path)
			throws Exception {
			if (path.lastIndexOf(File.separator) >= 0) {
				path = path.substring(path.lastIndexOf(File.separator) + 1, path.length());
			}
			return path;
		}
		
		public static String getParent(String path)
			throws Exception {
			return new File(path).getParentFile().getCanonicalPath();
		}
		
	// --- <<IS-END-SHARED>> ---
}

