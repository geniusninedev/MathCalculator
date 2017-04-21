package com.geniusnine.android.mathcalculators.Game;


import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.geniusnine.android.mathcalculators.R;


public class NameDialog extends Dialog {
    private String HALLOWEEN_ORANGE = "#FF7F27";
	String name;
	Game parent;


    String get_name( ) {
		return name;
	}

	public NameDialog(Game context, final Game.Outcome out, final int player_number, final String prev_name, int num_players) {
		super(context);

		this.setContentView(R.layout.name_dialog);
		final NameDialog me =NameDialog.this;

		parent = (Game) context;


        //
		/* can't get around it */
		//setCancelable(false);

		/* get our controls */
		final EditText entry = (EditText) findViewById(R.id.EditText01);
		final Button button = (Button) findViewById(R.id.Button01);
		final TextView heading = (TextView) findViewById(R.id.textView7);



		String h = new String( );


		if(player_number == 1) {
			if(out == Game.Outcome.P1_WON) h = "Player 1 (Winner)";
			else if(out == Game.Outcome.CAT) h = "Player 1";
			else h = "Player 1 (Loser)";
		} else {
			if(out == Game.Outcome.P1_WON) h = "Player 2 (Loser)";
			else if(out ==Game.Outcome.CAT) h = "Player 2";
			else h = "Player 2 (Winner)";
		}

		int np = 0;
		if(np == 1) h = "Player";

		heading.setText( h+"");

		button.setOnClickListener(new Button.OnClickListener( ) {
			public void onClick(View v) {
				name = entry.getText( ).toString( );

				if(player_number == 1) {
					parent.finishGame(out,player_number + 1, name, "");
				}
				else {
					parent.finishGame(out, player_number + 1, prev_name, name);
				}
				me.dismiss( );
			}
		});
	}



}
