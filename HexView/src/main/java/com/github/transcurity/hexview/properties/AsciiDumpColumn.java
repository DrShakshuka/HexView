/**
 * @author Andreas "PAX" Lück
 */
package com.github.transcurity.hexview.properties;

import com.vaadin.data.Item;
import com.vaadin.data.util.PropertyValueGenerator;

/**
 * A synthetic hex column which computes the ASCII representation of the current
 * row from the data and displays it.
 *
 * @author Andreas "PAX" Lück
 */
public class AsciiDumpColumn extends PropertyValueGenerator<String>
{
    private static final long serialVersionUID = -3781047797648966830L;

    /**
     * The binary data to be hold.
     *
     * @author Andreas "PAX" Lück
     */
    private final byte[] data;

    /**
     * @param data
     *            The binary data to be hold.
     *
     * @author Andreas "PAX" Lück
     */
    public AsciiDumpColumn(final byte[] data)
    {
        this.data = data;
    }

    @Override
    public String getValue(final Item item, final Object itemId,
            final Object propertyId)
    {
        if (itemId != null && itemId instanceof Integer)
        {
            final int offset = (int) itemId;
            return ColumnTypes.ASCII.getDisplayValue(this.data, offset);
        }

        return null;
    }

    @Override
    public Class<String> getType()
    {
        return String.class;
    }
}
