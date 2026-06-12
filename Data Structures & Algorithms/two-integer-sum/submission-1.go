func twoSum(nums []int, target int) []int {
    

    a := make(map[int]int)

    for i:=0; i<len(nums); i++{
        if _, ok := a[target - nums[i]]; ok{
            return []int{a[target - nums[i]], i}
        }

        a[nums[i]] = i
            
    }

    return []int{}
}
