public class viewerFactory {

    public  menu getOption(String option){
        if(option == null){
        return new Salutations();
        }
        if(option.equalsIgnoreCase("HASH")){
        return new Hash();
        } 
        else if(option.equalsIgnoreCase("TREE")){
            return new Tree();
        }
        else if(option.equalsIgnoreCase("LINKED")){
        return new LinkedHash();
        }
        return new Salutations();

    }
}