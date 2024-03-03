package main.ui.requests;

import DataInputUtil.main.ConsoleDataReader;
import main.model.utils.list.IMyList;
import main.model.utils.pagination.Paginator;

public class EntitiesPrinter {
    public static <T> void printEntities(String header, IMyList<T> entities) {
        System.out.println(header);
        Paginator<T> paginator = new Paginator<>(5, entities);
        System.out.println("Pages: " + paginator.getTotalPages());
        while(paginator.hasNextPage()){
            IMyList<T> page = paginator.getNextPage();
            System.out.println("Page#" + paginator.getCurPage() + "\n");
            for(int i = 0; i < page.count(); i++){
                int index = ((paginator.getCurPage() - 1) * paginator.getPageSize() + (i + 1));
                System.out.println(index + ". " + page.getAt(i));
            }
            if(paginator.hasNextPage()){
                String input = ConsoleDataReader.getLine("Input anything to get next page, or 'stop' to stop");
                if(input.equals("stop")){
                    break;
                }
            }
        }
    }
}