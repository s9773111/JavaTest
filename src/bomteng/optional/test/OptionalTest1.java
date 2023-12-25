package bomteng.optional.test;

import java.util.Optional;

public class OptionalTest1 {
	public static void main(String[] args) {
		// 1.建非null Optional
		String name = "Isaac";
		Optional<String> optName = Optional.of(name);
		System.out.println(optName);
		System.out.println(optName.get());
		
		// 2.建null Optional
		// 取出時仍然有Exception:  java.util.NoSuchElementException
		String name1 = null;
		optName = Optional.ofNullable(name1);
		System.out.println(optName);
		// 下方會出錯 java.util.NoSuchElementException
		//System.out.println(optName.get());
		
		// 3. 使用前先檢查 | 所以要用isPresent()
		String name2 = null;
		optName = Optional.ofNullable(name2);
		if (optName.isPresent()) {
			System.out.println("用isPresent(): " + optName.get());
		} else {
			System.out.println("用isPresent() Name is null.");
		}
		
		// 4. 使用前先檢查 另一種寫法
		Optional<String> optName2 = (name2==null) ? Optional.empty() : Optional.of(name2);
		//System.out.println(optName2.get()); // java.util.NoSuchElementException
		
		// 5. 使用前先檢查 orElse
		optName2 = Optional.ofNullable(name2);
		System.out.println(optName2.orElse("用ofNullable Name is Null."));
	}
}
