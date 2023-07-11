dir=$1
find $(realpath "${dir}") | grep "\.java" > temp.txt

for i in $(cat temp.txt)
do
    wc -l $i | awk '{print $1}' >> temp1.txt
done

echo $(paste -s -d+ temp1.txt | bc)

rm temp.txt
rm temp1.txt
