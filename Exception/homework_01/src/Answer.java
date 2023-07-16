class Answer {
    public int[] divArrays(int[] a, int[] b){
        if(a.length == b.length) {
            int[] c = new int[a.length];
            for (int i = 0; i < c.length; i++) {
                if(b[i] == 0){
                    throw new RuntimeException("div by zero element from array: b["+i+"] = 0");
                } else {
                    c[i] = a[i]/b[i];
                }
            }
            return c;
        }
        return new int[1];
    }
}


