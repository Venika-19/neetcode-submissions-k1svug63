func hasDuplicate(nums []int) bool {
    
    a := make(map[int]bool)

    for _, num := range nums {

        if a[num] {
            return true;
        }
           
        a[num] = true;
    }
    return false
}
