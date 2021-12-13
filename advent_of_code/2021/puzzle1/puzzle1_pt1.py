depth_array = open('/home/joao.pereira/pereirahere/advent_of_code/2021/puzzle1/depth_values.txt', 'r').read().splitlines()
counter = 0

for i in range(len(depth_array)-1):
    
    if int(depth_array[i]) < int(depth_array[i+1]):
        counter += 1
    
    i+=1

print('pz1 counter = ' + str(counter))