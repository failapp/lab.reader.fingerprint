
import com.digitalpersona.uareu.Engine;
import com.digitalpersona.uareu.Fid;
import com.digitalpersona.uareu.Fmd;
import com.digitalpersona.uareu.Reader;
import com.digitalpersona.uareu.UareUException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EnrollmentThread extends Thread implements Engine.EnrollmentCallback {

    private Reader r;
    private Engine e;
    private Reader.CaptureResult cr;

    public EnrollmentThread(Reader r, Engine e) {
        this.r = r;
        this.e = e;
    }

    @Override
    public void run() {
        GetFmd(Fmd.Format.ANSI_378_2004);
    }

    @Override
    public Engine.PreEnrollmentFmd GetFmd(Fmd.Format format) {
        Engine.PreEnrollmentFmd prefmd = null;

        try {
            while (null == prefmd) {
                cr = r.Capture(Fid.Format.ANSI_381_2004, Reader.ImageProcessing.IMG_PROC_PIV, 150, 10000);
            }
            System.out.println("cr " + cr);
        } catch (UareUException ex) {
            Logger.getLogger(EnrollmentThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prefmd;
    }
}
