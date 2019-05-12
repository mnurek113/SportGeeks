package com.code.knab.sportgeeks.ui.welcome

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.code.knab.sportgeeks.R
import com.code.knab.sportgeeks.network.json.SportEvent
import java.util.*

class DeviceListAdapter(context: Context, private val viewResourceId: Int, private val sportEventList: ArrayList<SportEvent>) : ArrayAdapter<SportEvent>(context, viewResourceId, sportEventList) {

    private val layoutInflater: LayoutInflater

    init {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val convertView = layoutInflater.inflate(viewResourceId, null)

        val sportEvent = sportEventList[position]

        if (sportEvent != null) {
            val deviceName = convertView!!.findViewById<View>(R.id.tvDeviceName) as TextView
            val deviceAdress = convertView.findViewById<View>(R.id.tvDeviceAddress) as TextView

            if (deviceName != null) {
                deviceName.text = sportEvent.sportType.polishText + " Data: " + sportEvent.startTime
            }
            if (deviceAdress != null) {
                deviceAdress.text = sportEvent.participationsNumber.toString()
            }
        }

        return convertView
    }

}
