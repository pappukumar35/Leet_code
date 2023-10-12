public class Solution2 {
    
        public int findInMountainArray(int target, MountainArray mountainArray) {
            int peak = peakIndex(mountainArray);
            int index = binarySearch(mountainArray, target,0,peak);
            if(index!=-1)
            {
                return index;
            }
            return binarySearch(mountainArray,target, peak+1,mountainArray.length()-1);
        }
        private int peakIndex(MountainArray mountainArray)
        {
            int left=0;
            int right = mountainArray.length()-1;
            while(left<right)
            {
                int mid = left + (right-left)/2;
                if(mountainArray.get(mid)>mountainArray.get(mid+1))
                {
                    right = mid;
                }
                else
                {
                    left = mid+1;
                }
            }
            return left;
        }
        private int binarySearch(MountainArray mountainArray, int target,  int left , int right)
        {
            boolean isAscending = mountainArray.get(left)<mountainArray.get(right);
            while(left<=right)
            {
                int mid = left +(right-left)/2;
                int midElement = mountainArray.get(mid);
    
                if(target==midElement)
                {
                    return mid;
                }
    
                if(isAscending)
                {
                    if(target>midElement)
                    {
                        left=mid+1;
                    }
                    else
                    {
                        right=mid-1;
                    }
                }
                else
                {
                    if(target>midElement)
                    {
                        right=mid-1;
                    }
                    else
                    {
                        left=mid+1;
                    }
                }
            }
            return -1;
        }
    }
}
