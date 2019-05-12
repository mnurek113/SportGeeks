package com.code.knab.sportgeeks.ui.map

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.code.knab.sportgeeks.R
import com.code.knab.sportgeeks.network.json.SportEvent
import java.util.*

class MyEventsListAdapter(context: Context, private val viewResourceId: Int, private val sportEventList: ArrayList<SportEvent>) : ArrayAdapter<SportEvent>(context, viewResourceId, sportEventList) {

    private val layoutInflater: LayoutInflater

    init {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val convertView = layoutInflater.inflate(viewResourceId, null)

        val sportEvent = sportEventList[position]

        if (sportEvent != null) {
            val sportAndDateTextView = convertView!!.findViewById<View>(R.id.tvDeviceName) as TextView
            val participationNumberTextView = convertView.findViewById<View>(R.id.tvDeviceAddress) as TextView

            if (sportAndDateTextView != null) {
                sportAndDateTextView.text = sportEvent.sportType.polishText + " Data: " + sportEvent.startTime
            }
            if (participationNumberTextView != null) {
                participationNumberTextView.text = sportEvent.participationsNumber.toString()
            }
        }

        return convertView
    }

}
