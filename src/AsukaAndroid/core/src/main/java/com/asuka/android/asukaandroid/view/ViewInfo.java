package com.asuka.android.asukaandroid.view;

/**
 * Author:Asuka
 * Time:2016-9-9
 * Mask:View信息
 */
/*package*/ final class ViewInfo {
    public int value;
    public int parentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewInfo viewInfo = (ViewInfo) o;

        if (value != viewInfo.value) return false;
        return parentId == viewInfo.parentId;

    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + parentId;
        return result;
    }
}
