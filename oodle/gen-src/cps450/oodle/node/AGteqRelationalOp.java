/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AGteqRelationalOp extends PRelationalOp
{
    private TGteqOp _gteqOp_;

    public AGteqRelationalOp()
    {
        // Constructor
    }

    public AGteqRelationalOp(
        @SuppressWarnings("hiding") TGteqOp _gteqOp_)
    {
        // Constructor
        setGteqOp(_gteqOp_);

    }

    @Override
    public Object clone()
    {
        return new AGteqRelationalOp(
            cloneNode(this._gteqOp_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAGteqRelationalOp(this);
    }

    public TGteqOp getGteqOp()
    {
        return this._gteqOp_;
    }

    public void setGteqOp(TGteqOp node)
    {
        if(this._gteqOp_ != null)
        {
            this._gteqOp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._gteqOp_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._gteqOp_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._gteqOp_ == child)
        {
            this._gteqOp_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._gteqOp_ == oldChild)
        {
            setGteqOp((TGteqOp) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
