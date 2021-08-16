
class TreeNode{
    private String value;
    private TreeNode left;
    private TreeNode right;
    private TreeNode parentNode;
    
    public TreeNode(String value){
        this.value = value;
        this.left = null;
        this.right = null;
        this.parentNode = null;
    }
    
    public TreeNode(String value, TreeNode parentNode){
        this.value = value;
        this.left = null;
        this.right = null;
        this.parentNode = parentNode;
    }
    
    public TreeNode(String value, TreeNode left, TreeNode right){
        this.value = value;
        this.left = left;
        this.right = right;
    }
    
    public TreeNode getLeft(){
        return left;
    }
    
    public TreeNode addLeft(String value){
        this.left = new TreeNode(value, this);
        return this.left;
    }
    
    public void setLeft(TreeNode node){
        this.left = node;
    }
    
    public TreeNode getRight(){
        return right;
    }
    
    public TreeNode addRight(String value){
        this.right = new TreeNode(value, this);
        return this.right;
    }
    
    public void setRight(TreeNode node){
        this.right = node;
    }
    
    public TreeNode getParent(){
        return this.parentNode;
    }
    
    public void setParent(TreeNode node){
        this.parentNode = node;
    }
    
    public String getValue(){
        return this.value;
    }
    
    public boolean isLeaf(){
        if(left == null || right == null){
            return true;
        } else{
            return false;
        }
    }
}
