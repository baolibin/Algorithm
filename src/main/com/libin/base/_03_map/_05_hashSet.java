package libin.base._03_map;

import java.util.HashSet;
import java.util.Iterator;

public class _05_hashSet {
	public static void main(String[] args) {
		HashSet<Object> hashSet = new HashSet<Object>();
		hashSet.add(new Persion("鲍礼彬", 24));
		hashSet.add(new Persion("hadoop", 10));
		hashSet.add(new Persion("spark", 5));
		hashSet.add(new Persion("鲍礼彬", 24));
		
		Iterator<Object> iterator=hashSet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}

class Persion{
	private String name;
	private int age;
	public Persion(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
/*	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persion other = (Persion) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}*/
	@Override
	public String toString() {
		return "Persion [name=" + name + ", age=" + age + "]";
	}
}
