
import com.digitalpersona.uareu.Engine;
import com.digitalpersona.uareu.Fmd;
import com.digitalpersona.uareu.Reader;
import com.digitalpersona.uareu.ReaderCollection;
import com.digitalpersona.uareu.UareUException;
import com.digitalpersona.uareu.UareUGlobal;
import java.util.logging.Level;
import java.util.logging.Logger;


public class App implements Engine.EnrollmentCallback{

    public static void main(String[] args) {
        try {
            ReaderCollection rc = UareUGlobal.GetReaderCollection();
            Engine e = UareUGlobal.GetEngine();
            rc.GetReaders();
            System.out.println(rc.size());
            Reader r = rc.get(0);
            
            System.out.println("Name : " + r.GetDescription().name + " \n"
                    + "Serial Number : " + r.GetDescription().serial_number + " \n"
                    + "ID : " + r.GetDescription().id.product_name + " " + r.GetDescription().id.vendor_name + " " + r.GetDescription().id.product_id + " " + r.GetDescription().id.vendor_id + "\n"
                    + "Modality : " + r.GetDescription().modality.name() + " \n"
                    + "Technology : " + r.GetDescription().technology.name() + " \n"
                    + "Version : " + r.GetDescription().version.toString() + " \n");
            
            EnrollmentThread et = new EnrollmentThread(r, e);
            et.start();
            
        } catch (UareUException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Engine.PreEnrollmentFmd GetFmd(Fmd.Format format) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
