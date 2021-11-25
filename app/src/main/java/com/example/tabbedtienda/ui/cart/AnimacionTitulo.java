package com.example.tabbedtienda.ui.cart;

import android.graphics.Color;
import android.os.AsyncTask;
import android.widget.TextView;

import com.example.tabbedtienda.ui.cart.CartFragment;

import org.w3c.dom.Text;

class AnimacionTitulo extends AsyncTask<Void, Integer, Void>
{
	private TextView tvTitulo;
	public AnimacionTitulo(TextView tv)
	{
		super();
		this.tvTitulo = tv;
	}
	@Override
	protected Void doInBackground(Void... voids)
	{
		for(int i=0; i<10; i++){
		//-----> Color: GREEN
		tvTitulo.setTextColor(000000);
		try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
		//-----> Color: BLUE
		tvTitulo.setTextColor(Color.RED);
		try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
		//-----> Color: RED
		tvTitulo.setTextColor(Color.BLUE);
		try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
	}




		return null;
	}
	@Override
	protected void onPreExecute()
	{
		super.onPreExecute();
	}
	@Override
	protected void onPostExecute(Void aVoid)
	{
		super.onPostExecute(aVoid);
	}
	@Override
	protected void onProgressUpdate(Integer... values)
	{
		super.onProgressUpdate(values);
	}
}
