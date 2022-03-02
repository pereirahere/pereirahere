fn main() {

    let mut s1 = String::from("test");
    let s2 = s1.clone();

    println!("{}, {}", s1, s2);

    do_stuff(&mut s1);

    fn do_stuff(s: &mut String) {
        s.insert_str(0, "Hi, ");
        *s = String::from("Replace")
    }

    println!("{}", s1)

}
