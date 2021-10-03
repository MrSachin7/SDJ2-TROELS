import client.model.TextConverter;
import client.model.TextConverterModel;
import client.view.uppercase.log.LogViewModel;



public class test {
    public static void main(String[] args) {
        TextConverter textConverterModel= new TextConverterModel();
        LogViewModel logViewModel = new LogViewModel(new TextConverterModel());
        String abc = "abc";
        textConverterModel.toUpperCase(abc);
        textConverterModel.toUpperCase("ekko");

        System.out.println(logViewModel.getLogs());

    }
}

