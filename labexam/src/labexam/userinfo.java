package labexam;
import java.util.*;
public class userinfo 
{
private String name;
private String pw;
private int userid;

public userinfo(String name, String pw) 
{
	super();
	this.name = name;
	this.pw = pw;
	
}

@Override
public String toString() {
	return "userinfo [name=" + name + ", pw=" + pw + "]";
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	userinfo other = (userinfo) obj;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (pw == null) {
		if (other.pw != null)
			return false;
	} else if (!pw.equals(other.pw))
		return false;
	return true;
}

public String getPw() {
	return pw;
}



}
