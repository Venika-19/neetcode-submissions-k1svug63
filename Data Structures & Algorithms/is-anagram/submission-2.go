func isAnagram(s string, t string) bool {

    a := [26]int{}

    if len(s) != len(t) {
        return false
    }

    for i :=0; i< len(s); i++ {

        a[s[i] - 'a']++;
        a[t[i] - 'a']--;
    }

    for _, num := range(a) {
        if(num != 0){
            return false
        }
    }
    return true
}
