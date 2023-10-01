package PictureChangingApplication;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class Project3 extends AppCompatActivity {

    private ImageView pictureImageView;
    private Button previousButton;
    private Button nextButton;
    private int currentImageIndex = 1;  // Index of the current image (assuming you start with image1)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pictureImageView = findViewById(R.id.pictureImageView);
        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentImageIndex > 1) {
                    currentImageIndex--;
                    updateImage();
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Assuming you have images named image1, image2, image3, etc.
                int maxImages = 3;  // Change this to match the total number of images you have
                if (currentImageIndex < maxImages) {
                    currentImageIndex++;
                    updateImage();
                }
            }
        });
    }

    private void updateImage() {
        int imageResource = getResources().getIdentifier("image" + currentImageIndex, "drawable", getPackageName());
        pictureImageView.setImageResource(imageResource);
    }
}
