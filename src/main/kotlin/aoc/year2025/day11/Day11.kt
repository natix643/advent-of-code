package aoc.year2025.day11

data class Device(
    val name: String,
    val outputs: MutableList<Device> = mutableListOf()
) {
    override fun toString(): String {
        return "Device(name=$name, outputs=${outputs.map { it.name }})"
    }
}

fun parseDevices(
    input: List<String>,
    startName: String,
    endName: String
): Device {
    val devicesByName = mutableMapOf(
        endName to Device(endName)
    )

    for (line in input) {
        val device = Device(name = line.split(':')[0])
        devicesByName[device.name] = device
    }

    for (line in input) {
        val parts = line.split(':')
        val name = parts[0]
        val outputs = parts[1].trim().split(' ')

        devicesByName.getValue(name).outputs.addAll(outputs.map {
            devicesByName.getValue(it)
        })
    }

    return devicesByName.getValue(startName)
}

object DeviceName {
    const val YOU = "you"
    const val OUT = "out"
    const val SVR = "svr"
    const val DAC = "dac"
    const val FFT = "fft"
}
