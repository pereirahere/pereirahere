from puzzle1_pt1 import depth_array

sum_array = []
sum_counter = 0

for i in range(len(depth_array)-3):
    
    sum = int(depth_array[i])+int((depth_array[i+1]))+int((depth_array[i+2]))
    sum_array.append(sum)
    
    i+=1

for i in range(len(sum_array)-1):
    
    if int(sum_array[i]) > int(sum_array[i+1]):
        sum_counter += 1
    
    i+=1

print(sum_counter)